package com.drpicox.game.matchers.entity;

import com.drpicox.game.matchers.InstructionMatcher;

public abstract class EntityInstructionMatcher extends InstructionMatcher {
    public EntityInstructionMatcher(String regExp) {
        super(regExp);

        andPrecondition(context ->
                context.has("game")
                        && context.has("cellEntities")
                        && context.has("it"));
    }
}
