package com.drpicox.game.matchers.map;

import com.drpicox.game.matchers.InstructionMatcher;

public abstract class MapInstructionMatcher extends InstructionMatcher {
    public MapInstructionMatcher(String regExp) {
        super(regExp);
        andPrecondition(context -> context.has("game"));
    }
}
