package com.drpicox.game.players;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Player {

    @Id
    private String id;

    private Race race;

    public Player(String id, Race race) {
        this.id = id;
        this.race = race;
    }
    public Player() {}

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Player player = (Player) o;
        return Objects.equals(id, player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Race getRace() {
        return race;
    }
}
