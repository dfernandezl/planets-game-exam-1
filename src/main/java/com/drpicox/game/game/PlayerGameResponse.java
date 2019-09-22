package com.drpicox.game.game;

import com.drpicox.game.players.Player;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.*;

public class PlayerGameResponse {

    private Map<String, Object> json = new HashMap<>();
    private Map<Number, Object> entities = new TreeMap<>();
    private List<Object> commands = new LinkedList<>();
    private List<Object> messages = new LinkedList<>();

    public PlayerGameResponse(Player player, com.drpicox.game.maps.Map map) {
        json.put("playerId", player.getId());
        json.put("race", player.getRace().name().toLowerCase());
        json.put("map", map.getJson());
        json.put("entities", entities.values());
        json.put("commands", commands);
        json.put("messages", messages);
    }

    void addEntity(Map<String, Object> entity) {
        entities.put((Number) entity.get("id"), entity);
    }

    void addCommand(Map<String, Object> command) {
        commands.add(command);
    }

    void addMessage(Map<String, Object> message) {
        messages.add(message);
    }

    @JsonValue
    public Object getJson() {
        return json;
    }
}
