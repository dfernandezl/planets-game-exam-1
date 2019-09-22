package com.drpicox.game.runners;

import com.drpicox.game.commands.CommandController;
import com.drpicox.game.ships.ShipController;
import com.drpicox.game.stars.StarController;
import org.springframework.stereotype.Component;

@Component
public class CR100Reproduce implements CommandRunner {

    private StarController starController;

    public CR100Reproduce(StarController starController) {
        this.starController = starController;
    }

    @Override
    public int getPriority() {
        return 100;
    }

    @Override
    public void run() {
        var stars = starController.listAll();
        for (var star: stars) {
            starController.reproducePopulation(star);
        }
    }
}
