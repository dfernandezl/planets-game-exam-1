package com.drpicox.game.matchers.game;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.interpreter.Snapshot;
import com.drpicox.game.matchers.OnResponseShowAlert;
import com.drpicox.game.matchers.login.OnSuccessSetGameInContext;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Click_the_Save_game_button extends GameInstructionMatcher {
    public Click_the_Save_game_button() {
        super("Click the _Save game_ button");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var playerId = context.wantJson("game").getAsString("playerId");
        var commands = context.wantJson("commands");

        var snapshot = new Snapshot("PUT", "/api/v1/players/" + playerId + "/commands", commands);
        snapshot.onSuccess(new OnResponseShowAlert(context, "game saved"));
        snapshot.onSuccess(new OnSuccessSetGameInContext(context, snapshot));

        context.set(Snapshot.class, snapshot);
    }
}
