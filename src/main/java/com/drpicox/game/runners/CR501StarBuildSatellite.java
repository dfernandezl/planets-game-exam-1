package com.drpicox.game.runners;

import com.drpicox.game.commands.CommandController;
import com.drpicox.game.entities.Entity;
import com.drpicox.game.messages.MessageController;
import com.drpicox.game.players.Player;
import com.drpicox.game.ships.ShipController;
import com.drpicox.game.stars.Star;
import com.drpicox.game.stars.StarController;
import org.springframework.stereotype.Component;

@Component
public class CR501StarBuildSatellite implements CommandRunner {

    private CommandController commandController;
    private ShipController shipController;
    private MessageController messageController;
    private StarController starController;

    public CR501StarBuildSatellite(CommandController commandController, ShipController shipController, MessageController messageController, StarController starController) {
        this.commandController = commandController;
        this.shipController = shipController;
        this.messageController = messageController;
        this.starController = starController;
    }

    @Override
    public int getPriority() {
        return 501;
    }

    @Override
    public void run() {
        var commands = commandController.listAllByType("BuildSatellite");

        for (var command : commands) {
            var entity = command.getEntity();
            buildSatellite(entity);
        }
    }

    private void buildSatellite(Entity entity) {
        if (!(entity instanceof Star)) return;
        var star = (Star) entity;

        var hasMinerals = starController.consumeMinerals(star,7);
        if (hasMinerals) {
            starController.boostPopulation(star);
        }
    }
}
