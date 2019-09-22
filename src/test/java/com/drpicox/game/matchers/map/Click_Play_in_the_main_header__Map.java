package com.drpicox.game.matchers.map;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Click_Play_in_the_main_header__Map extends MapInstructionMatcher {
    public Click_Play_in_the_main_header__Map() {
        super("Click _Play_ in the main header");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
    }
}
