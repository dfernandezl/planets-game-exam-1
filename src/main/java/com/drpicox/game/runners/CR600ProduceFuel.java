package com.drpicox.game.runners;

import com.drpicox.game.messages.MessageController;
import com.drpicox.game.starbases.StarbaseController;
import org.springframework.stereotype.Component;

@Component
public class CR600ProduceFuel implements CommandRunner {

    private StarbaseController starbaseController;
    private MessageController messageController;

    public CR600ProduceFuel(StarbaseController starbaseController, MessageController messageController) {
        this.starbaseController = starbaseController;
        this.messageController = messageController;
    }

    @Override
    public int getPriority() {
        return 600;
    }

    @Override
    public void run() {
        var starbases = starbaseController.listAll();

        for (var starbase: starbases) {
            starbaseController.produceFuel(starbase);
        }
    }

}
