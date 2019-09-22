package com.drpicox.game.matchers.entity;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

import static com.drpicox.game.tools.JsonSubject.assertThat;

@Component
public class It_has_no_owner extends EntityInstructionMatcher {
    public It_has_no_owner() {
        super("It has no _owner_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var it = context.wantJson("it");

        assertThat(it).at("playerId").isNull();
    }
}
