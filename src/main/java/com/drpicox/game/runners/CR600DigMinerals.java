package com.drpicox.game.runners;

import com.drpicox.game.commands.CommandController;
import com.drpicox.game.entities.Coordinates;
import com.drpicox.game.messages.MessageController;
import com.drpicox.game.ships.Ship;
import com.drpicox.game.ships.ShipController;
import com.drpicox.game.stars.Star;
import com.drpicox.game.stars.StarController;
import org.springframework.stereotype.Component;

import static java.lang.Math.min;

@Component
public class CR600DigMinerals implements CommandRunner {

    private StarController starController;
    private MessageController messageController;

    public CR600DigMinerals(StarController starController, MessageController messageController) {
        this.starController = starController;
        this.messageController = messageController;
    }

    @Override
    public int getPriority() {
        return 600;
    }

    @Override
    public void run() {
        var stars = starController.listAll();

        for (var star: stars) {
            starController.digMinerals(star);
        }
    }

}
