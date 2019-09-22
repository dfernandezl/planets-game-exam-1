package com.drpicox.game.runners;

import com.drpicox.game.commands.CommandController;
import com.drpicox.game.entities.Entity;
import com.drpicox.game.stars.Star;
import com.drpicox.game.stars.StarController;
import org.springframework.stereotype.Component;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

@Component
public class CR100BuildDroids implements CommandRunner {

    private StarController starController;
    private CommandController commandController;

    public CR100BuildDroids(StarController starController, CommandController commandController) {
        this.starController = starController;
        this.commandController = commandController;
    }

    @Override
    public int getPriority() {
        return 100;
    }

    @Override
    public void run() {
        var commands = commandController.listAllByType("BuildDroids");

        for (var command : commands) {
            var star = (Star) command.getEntity();
            var amount = Integer.parseInt(command.getValue());
            buildDroids(star, amount);
        }
    }

    private void buildDroids(Star star, int amount) {
        var mineralsLimit = star.getMinerals() * 5;
        var populationLimit = star.getMaxPopulation() - star.getPopulation();
        var real = max(0, min(amount, min(mineralsLimit, populationLimit)));

        var cost = (real + 4) / 5;
        starController.consumeMinerals(star, cost);
        starController.addPopulation(star, real);
    }
}
