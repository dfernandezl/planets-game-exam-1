package com.drpicox.game.matchers.entity;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.tools.Json;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

import static com.drpicox.game.tools.JsonSubject.assertThat;

@Component
public class It_has_X_typed_into_the_new_ship_game extends EntityInstructionMatcher {
    public It_has_X_typed_into_the_new_ship_game() {
        super("It has _([^_]+)_ typed into the _new ship name_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var expected = new Json("{}")
                .set("entityId", context.wantJson("it").get("id"))
                .set("type", "BuildShip")
                .set("value", match.group(1));

        var commands = context.wantJson("commands");
        assertThat(commands).containsMatch(expected);
    }
}
