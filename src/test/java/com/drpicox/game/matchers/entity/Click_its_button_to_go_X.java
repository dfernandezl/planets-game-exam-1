package com.drpicox.game.matchers.entity;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.tools.Json;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Click_its_button_to_go_X extends EntityInstructionMatcher {
    public Click_its_button_to_go_X() {
        super("Click its button to _go ([^_]+)_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var value = match.group(1);
        var entityId = context.wantJson("it").get("id");
        var command = new Json("{}")
                .set("value", value)
                .set("entityId", entityId)
                .set("type", "MoveShip");

        context.wantJson("commands").add(command);
    }
}
