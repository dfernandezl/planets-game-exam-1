package com.drpicox.game.matchers.map;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

import static com.drpicox.game.tools.JsonSubject.assertThat;

@Component
public class It_is_the_turn_number_X extends MapInstructionMatcher {
    public It_is_the_turn_number_X() {
        super("It is the turn number _([^_]+)_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var turnNumber = Integer.parseInt(match.group(1));
        var game = context.wantJson("game");

        assertThat(game).at("map.turnNumber").asNumber().isEqualTo(turnNumber);
    }
}
