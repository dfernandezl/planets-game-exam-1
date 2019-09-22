package com.drpicox.game.matchers.map;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.tools.Json;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Click_at_coordinates_X extends MapInstructionMatcher {
    public Click_at_coordinates_X() {
        super("Click at coordinates _(\\d),(\\d)_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var row = Integer.parseInt(match.group(1));
        var column = Integer.parseInt(match.group(2));
        var entities = (Json) context.wantFor("game");

        var model = new Json("{}");
        model.set("row", row);
        model.set("column", column);
        var cellEntities = entities.get("entities").filter(e -> e.matches(model));

        context.set("cellEntities", cellEntities);
    }
}
