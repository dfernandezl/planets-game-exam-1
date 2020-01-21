package com.drpicox.game.matchers.entity;

import com.drpicox.game.matchers.InstructionMatcher;

public abstract class EntityInstructionMatcher extends InstructionMatcher {
    public EntityInstructionMatcher(String regExp) {
        super(regExp);

        andRequires("game", "cellEntities", "it");
    }
}
