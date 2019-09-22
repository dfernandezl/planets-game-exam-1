package com.drpicox.game.maps;

import com.drpicox.game.players.Player;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.LinkedHashMap;
import java.util.List;

@Entity
public class Map {

    @Id private String id;
    private int turnNumber;
    @OneToMany private List<Player> players;

    public Map(String id, List<Player> players) {
        this.id = id;
        this.turnNumber = 1;
        this.players = players;
    }
    public Map() {}

    public String getId() {
        return id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void increaseTurnNumber() {
        turnNumber += 1;
    }

    public Player getNextPlayer(Player player) {
        var index = players.indexOf(player);
        return players.get((index + 1) % players.size());
    }

    void addPlayer(Player player) {
        this.players.add(player);
    }

    public java.util.Map<String, Object> getJson() {
        return new LinkedHashMap<>() {{
            put("id", getId());
            put("rows", 8);
            put("columns", 8);
            put("turnNumber", turnNumber);
            put("players", players.stream().map(p -> p.getId()));
        }};
    }
}
