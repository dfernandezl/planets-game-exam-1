package com.drpicox.game.matchers.game;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Click_Game_in_the_main_header extends GameInstructionMatcher {
    public Click_Game_in_the_main_header() {
        super("Click _Game_ in the main header");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
    }
}
