package com.drpicox.game.matchers.map;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.tools.Json;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

import static com.drpicox.game.tools.JsonSubject.assertThat;

@Component
public class The_current_player_is_X extends MapInstructionMatcher {
    public The_current_player_is_X() {
        super("The current player is _([^_]+)_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var playerId = match.group(1);
        var game = context.wantJson("game");

        assertThat(game).at("playerId").asString().isEqualTo(playerId);
    }
}
