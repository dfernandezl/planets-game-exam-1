package com.drpicox.game.commands;

import com.drpicox.game.entities.Entity;
import com.drpicox.game.players.Player;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import java.util.LinkedHashMap;
import java.util.Map;

@javax.persistence.Entity
@IdClass(CommandId.class)
public class Command {

    @Id
    @ManyToOne
    private Player player;
    @Id
    @ManyToOne
    private Entity entity;
    @Id
    private String type;
    private String value;

    public Command(Player player, Entity entity, String type, String value) {
        this.player = player;
        this.entity = entity;
        this.type = type;
        this.value = value;
    }
    public Command() {} // JPA constructor

    public Player getPlayer() {
        return player;
    }

    public<T extends Entity> T getEntity() {
        return (T) entity;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public Map<String, Object> getJson() {
        return new LinkedHashMap<>() {{
            put("entityId", entity.getId());
            put("type", type);
            put("value", value);
        }};
    }
}
