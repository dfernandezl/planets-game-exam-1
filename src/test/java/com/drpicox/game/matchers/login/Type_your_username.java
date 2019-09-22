package com.drpicox.game.matchers.login;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Type_your_username extends LoginInstructionMatcher {
    public Type_your_username() {
        super("Type your username");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        context.wantJson("login").set("playerId", "yours");
    }
}
