package com.drpicox.game.satellite;

import com.drpicox.game.entities.Coordinates;
import com.drpicox.game.entities.Entity;
import com.drpicox.game.players.Player;
import com.drpicox.game.stars.Star;

import java.util.Map;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

@javax.persistence.Entity
public class Satellite extends Entity {

    private int level;

    Satellite(Player player, String name, Coordinates coordinates) {
        super(player, name, coordinates, "satellite");

        this.level = 1;
    }
    public Satellite() {} // JPA constructor



    @Override
    public Map<String, Object> getOwnJson() {
        var result = super.getOwnJson();
        result.put("level", level);
        return result;
    }

    public int getLevel() {
        return level;
    }

    public void upgradeLevel() {
        level +=1;
    }
}
