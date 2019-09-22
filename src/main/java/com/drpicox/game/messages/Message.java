package com.drpicox.game.messages;

import com.drpicox.game.entities.Coordinates;
import com.drpicox.game.players.Player;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.LinkedHashMap;
import java.util.Map;

@javax.persistence.Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Player player;

    private String text;

    @Embedded
    private Coordinates coordinates;

    public Message(Player player, String text, @Nullable Coordinates coordinates) {
        this.player = player;
        this.text = text;
        this.coordinates = coordinates;
    }
    public Message(){}

    public Map<String, Object> getJson() {
        return new LinkedHashMap<>() {{
            put("playerId", player.getId());
            put("text", text);
            put("coordinates", coordinates == null ? null : coordinates.getJson());
        }};
    }

}
