package com.drpicox.game.matchers.newGame;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.interpreter.Snapshot;
import com.drpicox.game.matchers.OnResponseShowBodyMessageAlert;
import com.drpicox.game.matchers.login.OnSuccessSetGameInContext;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Click_the_Create_button extends NewGameInstructionMatcher {
    public Click_the_Create_button() {
        super("Click the _Create_ button");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var newGame = context.wantJson("newGame");
        var snapshot = new Snapshot("PUT", "/api/v1/game", newGame);
        snapshot.onFailure(new OnResponseShowBodyMessageAlert(context));
        snapshot.onSuccess(new OnSuccessSetGameInContext(context, snapshot));
        context.set(Snapshot.class, snapshot);
    }
}
