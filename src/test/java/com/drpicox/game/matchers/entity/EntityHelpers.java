package com.drpicox.game.matchers.entity;

import com.drpicox.game.tools.Json;

public class EntityHelpers {

    public static void insertCommand(Json commands, Json command) {
        var index = 0;
        var entityId = command.getAsNumber("entityId");
        var type = command.getAsString("type");
        while (index < commands.size()) {
            var current = commands.get(index);
            var compare = current.getAsNumber("entityId").compareTo(entityId);
            if (compare > 0) break;
            if (compare == 0 && current.getAsString("type").compareTo(type) > 0) break;
            index += 1;
        }

        commands.insert(index, command);
    }

}
