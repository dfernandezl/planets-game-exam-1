package com.drpicox.game.matchers.login;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.interpreter.Snapshot;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Click_the_Log_in_button extends LoginInstructionMatcher {
    public Click_the_Log_in_button() {
        super("Click the _Log in_ button");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var playerId = context.wantJson("login").getAsString("playerId");
        var snapshot = new Snapshot("GET", "/api/v1/players/" + playerId, null);
        snapshot.onSuccess(new OnSuccessSetGameInContext(context, snapshot));

        context.set(Snapshot.class, snapshot);
    }
}
