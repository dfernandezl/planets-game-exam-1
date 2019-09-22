package com.drpicox.game.starbases;

import com.drpicox.game.entities.Coordinates;
import com.drpicox.game.entities.Entity;
import com.drpicox.game.players.Player;
import com.drpicox.game.stars.Star;

import javax.persistence.ManyToOne;
import java.util.Map;

import static java.lang.Math.min;

@javax.persistence.Entity
public class Starbase extends Entity {

    @ManyToOne
    private Star star;

    private int fuel;

    Starbase(Star star, String name) {
        super(star.getPlayer(), name, star.getCoordinates(), "starbase");

        this.star = star;
        this.fuel = -2;
    }
    public Starbase() {} // JPA constructor

    public int getMaxFuel() {
        return 10;
    }

    void produceFuel() {
        this.fuel = min(getMaxFuel(), fuel + 2);
    }

    void consumeFuel(int amount) {
        this.fuel -= amount;
    }

    public int getFuel() {
        return fuel;
    }

    @Override
    public Map<String, Object> getOwnJson() {
        var result = super.getOwnJson();
        result.put("fuel", fuel);
        result.put("maxFuel", getMaxFuel());
        return result;
    }

    /////// IMPORTANT NOTE:
    //////
    ////// The following code tell us that Entity is a bad abstraction
    ////// and it carries too much complexity.
    ////// Following the SOLID principles
    ////// we should split Entity in:
    //////   Entity (with id, name, and abstract getPlayer, ...)
    //////   LocatedAssignableEntity (with player, coordinates)
    //////   ComponentEntity (with relates to assignable entity)
    ////// In fact Locatable, Composable, Assignable, are components of Entity, not Entity itself
    ////// But, because it is code for an exam, no more abstractions are introduced
    ////// neither you have during the exam.

    @Override
    public Player getPlayer() {
        return star.getPlayer();
    }

    @Override
    public Coordinates getCoordinates() {
        return star.getCoordinates();
    }

}
