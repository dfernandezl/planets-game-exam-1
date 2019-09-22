package com.drpicox.game.entities;

import com.drpicox.game.players.Player;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@javax.persistence.Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Entity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @Embedded
    private Coordinates coordinates;
    private String type;
    @ManyToOne
    private Player player;

    public Entity(String name, Coordinates coordinates, String type) {
        this(null, name, coordinates, type);
    }

    public Entity(Player player, String name, Coordinates coordinates, String type) {
        this.player = player;
        this.name = name;
        this.coordinates = coordinates;
        this.type = type;
    }
    public Entity() {} // JPA constructor

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public boolean hasPlayer() {
        return getPlayer() != null;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    protected void assignPlayer(Player player) {
        this.player = player;
    }

    public void moveEntity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Map<String, Object> getVisibleJson() {
        return new LinkedHashMap<>() {{
            put("id", getId());
            put("type", getType());
            put("name", getName());
            putAll(getCoordinates().getJson());
            put("playerId", hasPlayer() ? getPlayer().getId() : null);
        }};
    }

    public Map<String, Object> getOwnJson() {
        return this.getVisibleJson();
    }


    public Player getPlayer() {
        return player;
    }

}
