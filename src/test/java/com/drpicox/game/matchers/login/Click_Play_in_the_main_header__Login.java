package com.drpicox.game.matchers.login;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Click_Play_in_the_main_header__Login extends LoginInstructionMatcher {
    public Click_Play_in_the_main_header__Login() {
        super("Click _Play_ in the main header");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        context.setJson("login", "{}");
    }
}
