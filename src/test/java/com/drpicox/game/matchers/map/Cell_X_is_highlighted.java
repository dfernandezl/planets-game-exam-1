package com.drpicox.game.matchers.map;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.tools.Json;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Cell_X_is_highlighted extends MapInstructionMatcher {
    public Cell_X_is_highlighted() {
        super("cell _[^_]+_ is highlighted");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
    }
}
