package com.drpicox.game.matchers.entity;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.tools.Json;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

import static com.drpicox.game.matchers.entity.EntityHelpers.insertCommand;

@Component
public class Type_X_into_its_upgrade_satellite extends EntityInstructionMatcher {
    public Type_X_into_its_upgrade_satellite() {
        super("Type _([^_]+)_ into its _upgrade satellite_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var value = match.group(1);
        var entityId = context.wantJson("it").get("id");
        var command = new Json("{}")
                .set("value", value)
                .set("entityId", entityId)
                .set("type", "UpgradeSatellite");

        insertCommand(context.wantJson("commands"), command);
    }
}
