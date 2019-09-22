package com.drpicox.game.players;

public enum Race {
    HUMAN(1.1, .1, 1),
    REPTILIAN(1.05, .05, 2),
    DROID(1.0, .1, 1),
    ;

    private final double fertility;
    private final double digRatio;
    private final double damage;

    Race(double fertility, double digRatio, double damage) {
        this.fertility = fertility;
        this.digRatio = digRatio;
        this.damage = damage;
    }

    public double getFertility() {
        return fertility;
    }

    public double getDigRatio() {
        return digRatio;
    }

    public double getDamage() {
        return damage;
    }
}
