package com.drpicox.game.matchers.entity;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.tools.Json;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

import static com.drpicox.game.matchers.entity.EntityHelpers.insertCommand;

@Component
public class Type_X_into_its_load extends EntityInstructionMatcher {
    public Type_X_into_its_load() {
        super("Type _([^_]+)_ into its _load_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var value = match.group(1);
        var entityId = context.wantJson("it").get("id");
        var command = new Json("{}")
                .set("value", value)
                .set("entityId", entityId)
                .set("type", "LoadShip");

        insertCommand(context.wantJson("commands"), command);
    }
}
