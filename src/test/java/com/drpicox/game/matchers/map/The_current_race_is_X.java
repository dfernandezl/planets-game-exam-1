package com.drpicox.game.matchers.map;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

import static com.drpicox.game.tools.JsonSubject.assertThat;

@Component
public class The_current_race_is_X extends MapInstructionMatcher {
    public The_current_race_is_X() {
        super("The current race is _([^_]+)_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var race = match.group(1);
        var game = context.wantJson("game");

        assertThat(game).at("race").asString().isEqualTo(race);
    }
}
