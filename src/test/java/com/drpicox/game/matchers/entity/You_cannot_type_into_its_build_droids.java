package com.drpicox.game.matchers.entity;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.tools.Json;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

import static com.drpicox.game.matchers.entity.EntityHelpers.insertCommand;

@Component
public class You_cannot_type_into_its_build_droids extends EntityInstructionMatcher {
    public You_cannot_type_into_its_build_droids() {
        super("You cannot type into its _build droids_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
    }
}
