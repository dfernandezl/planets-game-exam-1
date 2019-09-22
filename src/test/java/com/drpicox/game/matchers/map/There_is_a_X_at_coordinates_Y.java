package com.drpicox.game.matchers.map;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.tools.Json;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

import static com.drpicox.game.tools.JsonSubject.assertThat;

@Component
public class There_is_a_X_at_coordinates_Y extends MapInstructionMatcher {
    public There_is_a_X_at_coordinates_Y() {
        super("There (is a|are) _([^_]+)_ at coordinates _(\\d),(\\d)_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var type = match.group(2);
        if (type.endsWith("s")) type = type.substring(0, type.length() - 1);
        var row = Integer.parseInt(match.group(3));
        var column = Integer.parseInt(match.group(4));
        var game = (Json) context.wantFor("game");

        var expected = new Json("{}");
        expected.set("type", type);
        expected.set("row", row);
        expected.set("column", column);

        assertThat(game).at("entities").containsMatch(expected);
    }
}
