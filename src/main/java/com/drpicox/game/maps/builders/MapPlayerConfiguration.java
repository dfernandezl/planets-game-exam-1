package com.drpicox.game.maps.builders;

import com.drpicox.game.players.Race;

public class MapPlayerConfiguration {
    private String playerId;
    private String race;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Race getCanonicalRace() {
        return Race.valueOf(race.toUpperCase());
    }
}
