package com.drpicox.game.maps.builders;

import java.util.List;

public class MapConfiguration {
    private String mapCode;
    private List<MapPlayerConfiguration> players;

    public String getMapCode() {
        return mapCode;
    }

    public void setMapCode(String mapCode) {
        this.mapCode = mapCode;
    }

    public List<MapPlayerConfiguration> getPlayers() {
        return players;
    }

    public void setPlayers(List<MapPlayerConfiguration> players) {
        this.players = players;
    }

    public boolean hasPlayers() {
        return !this.players.isEmpty();
    }

    public MapPlayerConfiguration getPlayer(int playerNumber) {
        return this.players.get(playerNumber - 1);
    }
}
