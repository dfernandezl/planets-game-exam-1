package com.drpicox.game.ships;

import com.drpicox.game.entities.Coordinates;
import com.drpicox.game.entities.Entity;
import com.drpicox.game.players.Player;

import java.util.Map;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

@javax.persistence.Entity
public class Ship extends Entity {

    private int size;
    private int population;
    private int fuel;

    Ship(Player player, String name, Coordinates coordinates, int size) {
        super(player, name, coordinates, "ship");

        this.size = size;
        this.population = 0;
        this.fuel = getMaxFuel() / 2;
    }
    public Ship() {} // JPA constructor

    void loadPopulation(int amount) {
        this.population = max(0, min(getMaxPopulation(), amount + population));
    }

    public void moveEntity(Coordinates coordinates) {
        if (fuel == 0) return;
        this.fuel -= 1;
        super.moveEntity(coordinates);
    }

    void refuel(int amount) {
        this.fuel += amount;
    }

    public int getPopulation() {
        return population;
    }

    public int getMaxPopulation() {
        return size;
    }

    public int getMissingFuel() {
        return getMaxFuel() - fuel;
    }

    public int getMaxFuel() {
        return size / 10;
    }


    @Override
    public Map<String, Object> getOwnJson() {
        var result = super.getOwnJson();
        result.put("population", population);
        result.put("maxPopulation", getMaxPopulation());
        result.put("fuel", fuel);
        result.put("maxFuel", getMaxFuel());
        return result;
    }

}
