package com.drpicox.game.matchers.map;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.interpreter.Snapshot;
import com.drpicox.game.matchers.OnResponseShowAlert;
import com.drpicox.game.matchers.game.GameInstructionMatcher;
import com.drpicox.game.matchers.login.OnSuccessSetGameInContext;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Click_the_Next_button extends MapInstructionMatcher {
    public Click_the_Next_button() {
        super("Click the _Next_ button");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var playerId = context.wantJson("game").getAsString("playerId");
        var commands = context.wantJson("commands");

        var snapshot = new Snapshot("PUT", "/api/v1/players/" + playerId + "/next", commands);
        snapshot.onSuccess(new OnSuccessSetGameInContext(context, snapshot));

        context.set(Snapshot.class, snapshot);
    }
}
