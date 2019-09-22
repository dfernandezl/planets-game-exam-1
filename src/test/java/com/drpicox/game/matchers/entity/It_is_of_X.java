package com.drpicox.game.matchers.entity;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

import static com.drpicox.game.tools.JsonSubject.assertThat;

@Component
public class It_is_of_X extends EntityInstructionMatcher {
    public It_is_of_X() {
        super("It is of _([^_]+)_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var playerId = match.group(1);
        var it = context.wantJson("it");

        assertThat(it).at("playerId").asString().isEqualTo(playerId);
    }
}
