package com.drpicox.game.matchers.entity;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

import static com.drpicox.game.tools.JsonSubject.assertThat;

@Component
public class It_has_a_population_of_Y extends EntityInstructionMatcher {
    public It_has_a_population_of_Y() {
        super("It has a _population_ of _([^_]+)_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var expected = Integer.parseInt(match.group(1));
        var it = context.wantJson("it");

        assertThat(it).at("population").asNumber().isEqualTo(expected);
    }
}
