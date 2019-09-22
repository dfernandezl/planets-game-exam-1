package com.drpicox.game.matchers.cellEntities;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Click_the_Back_button extends CellEntitiesInstructionMatcher {
    public Click_the_Back_button() {
        super("Click the _Back_ button");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        context.remove("cellEntities");
    }
}
