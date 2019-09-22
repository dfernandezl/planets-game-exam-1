package com.drpicox.game.runners;

import com.drpicox.game.commands.CommandController;
import com.drpicox.game.entities.Entity;
import com.drpicox.game.messages.MessageController;
import com.drpicox.game.players.Player;
import com.drpicox.game.starbases.StarbaseController;
import com.drpicox.game.stars.StarController;
import org.springframework.stereotype.Component;

@Component
public class CR500StarBuildStarbase implements CommandRunner {

    private CommandController commandController;
    private StarbaseController starbaseController;
    private MessageController messageController;
    private StarController starController;

    public CR500StarBuildStarbase(CommandController commandController, StarbaseController starbaseController, MessageController messageController, StarController starController) {
        this.commandController = commandController;
        this.starbaseController = starbaseController;
        this.messageController = messageController;
        this.starController = starController;
    }

    @Override
    public int getPriority() {
        return 500;
    }

    @Override
    public void run() {
        var commands = commandController.listAllByType("BuildStarbase");

        for (var command : commands) {
            var player = command.getPlayer();
            var entity = command.getEntity();
            var name = command.getValue();
            buildStarbase(player, entity, name);
        }
    }

    private void buildStarbase(Player player, Entity entity, String name) {
        var coordinates = entity.getCoordinates();
        var star = starController.getStar(coordinates);

        var hasMinerals = starController.consumeMinerals(star,10);
        if (hasMinerals) {
            starbaseController.createStarbase(star, name);
            messageController.sendMessage(player, "Created the " + name + " starbase", coordinates);
        } else {
            messageController.sendMessage(player, "Cannot build starbase " + name + " due to a lack of available minerals", coordinates);
        }
    }
}
