package com.drpicox.game.stars;

import com.drpicox.game.entities.Coordinates;
import com.drpicox.game.entities.Entity;
import com.drpicox.game.players.Player;

import java.util.Map;

import static java.lang.Integer.max;
import static java.lang.Math.min;

@javax.persistence.Entity
public class Star extends Entity {

    private int size;
    private int population;
    private int minerals;
    private int mineralsReserve;
    private int populationBoost;

    public Star(String name, Coordinates coordinates, int size, int population) {
        super(name, coordinates, "star");
        this.size = size;
        this.population = population;
        this.minerals = 5;
        this.mineralsReserve = size;
        this.populationBoost = 0;
    }
    public Star() {} // JPA constructor

    public int getMinerals() {
        return minerals;
    }

    public int getPopulation() {
        return population;
    }

    public int getMaxPopulation() {
        return size;
    }

    public Map<String, Object> getDistantJson() {
        var result = super.getVisibleJson();
        result.remove("playerId");
        return result;
    }

    public Map<String, Object> getVisibleJson() {
        var result = super.getVisibleJson();
        result.put("population", population);
        result.put("maxPopulation", getMaxPopulation());
        result.put("minerals", minerals);
        result.put("mineralsReserve", mineralsReserve);
        result.put("populationBoost", populationBoost);

        return result;
    }

    void extractPopulation(int amount) {
        this.population -= amount;
    }

    void reproducePopulation() {
        if (!hasPlayer()) return;
        var fertility = getPlayer().getRace().getFertility();
        this.population = normalizePopulation((int) (population * fertility) + populationBoost);
    }

    void looseBattle(Player player, int survivors) {
        this.population = normalizePopulation(survivors);
        this.assignPlayer(player);
    }

    void winsBattle(int survivors) {
        this.population = normalizePopulation(survivors);
        if (survivors == 0) this.assignPlayer(null);
    }

    void addPopulation(int amount) {
        this.population = normalizePopulation(population + amount);
    }

    boolean digMinerals() {
        if (!hasPlayer()) return false;

        var digRatio = getPlayer().getRace().getDigRatio();
        int amount = min((int) Math.sqrt(population * digRatio), mineralsReserve);
        if (amount == 0) return false;

        mineralsReserve -= amount;
        minerals += amount;

        return true;
    }

    boolean consumeMinerals(int amount) {
        if (minerals < amount) return false;

        minerals -= amount;
        return true;
    }

    private int normalizePopulation(int population) {
        return max(0, min(getMaxPopulation(), population));
    }

    public void boostPoplation(int level) {
        populationBoost += level;
    }
}
