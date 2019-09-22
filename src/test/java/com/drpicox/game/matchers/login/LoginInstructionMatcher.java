package com.drpicox.game.matchers.login;

import com.drpicox.game.matchers.InstructionMatcher;

public abstract class LoginInstructionMatcher extends InstructionMatcher {
    public LoginInstructionMatcher(String regExp) {
        super(regExp);

        andPrecondition(context -> !context.has("game"));
    }
}
