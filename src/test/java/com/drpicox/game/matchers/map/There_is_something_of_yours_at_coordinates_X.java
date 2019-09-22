package com.drpicox.game.matchers.map;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.tools.Json;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

import static com.drpicox.game.tools.JsonSubject.assertThat;

@Component
public class There_is_something_of_yours_at_coordinates_X extends MapInstructionMatcher {
    public There_is_something_of_yours_at_coordinates_X() {
        super("There is something of (\\w+) at coordinates _(\\d),(\\d)_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var playerId = match.group(1);
        var row = Integer.parseInt(match.group(2));
        var column = Integer.parseInt(match.group(3));
        var game = (Json) context.wantFor("game");

        var expected = new Json("{}");
        expected.set("playerId", playerId);
        expected.set("row", row);
        expected.set("column", column);

        assertThat(game).at("entities").containsMatch(expected);
    }
}
