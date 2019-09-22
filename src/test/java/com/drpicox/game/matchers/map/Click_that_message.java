package com.drpicox.game.matchers.map;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.tools.Json;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

import static com.drpicox.game.tools.JsonSubject.assertThat;

@Component
public class Click_that_message extends MapInstructionMatcher {
    public Click_that_message() {
        super("Click that message");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var coordinates = context.wantJson("thatMessage").get("coordinates");
        var cellEntities = context.wantJson("game").get("entities").filter(e -> e.matches(coordinates));

        context.set("cellEntities", cellEntities);
        context.remove("thatMessage");
    }
}
