package com.drpicox.game.matchers.newGame;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Click_New_in_the_main_header extends NewGameInstructionMatcher {
    public Click_New_in_the_main_header() {
        super("Click _New_ in the main header");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        context.setJson("newGame", "{players:[]}");
    }
}
