package com.drpicox.game.matchers.game;

import com.drpicox.game.matchers.InstructionMatcher;

public abstract class GameInstructionMatcher extends InstructionMatcher {
    public GameInstructionMatcher(String regExp) {
        super(regExp);
    }
}
