package com.drpicox.game.matchers;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Now_you_see_the_X extends  InstructionMatcher {
    public Now_you_see_the_X() {
        super("Now you see the _[^_]+_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
    }
}
