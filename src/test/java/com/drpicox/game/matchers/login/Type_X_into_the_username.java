package com.drpicox.game.matchers.login;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.matchers.newGame.NewGameInstructionMatcher;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Type_X_into_the_username extends NewGameInstructionMatcher {
    public Type_X_into_the_username() {
        super("Type _([^_]+)_ into the _username_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var value = match.group(1);
        context.wantJson("login").set("playerId", value);
    }
}
