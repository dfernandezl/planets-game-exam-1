package com.drpicox.game.matchers.game;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Click_the_Logout_button extends GameInstructionMatcher {
    public Click_the_Logout_button() {
        super("Click the _Logout_ button");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        context.remove("game");
        context.remove("commands");
        context.remove("cellEntities");
        context.remove("it");
    }
}
