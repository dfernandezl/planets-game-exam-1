package com.drpicox.game.matchers.newGame;

import com.drpicox.game.matchers.InstructionMatcher;

public abstract class NewGameInstructionMatcher extends InstructionMatcher {
    public NewGameInstructionMatcher(String regExp) {
        super(regExp);
    }
}
