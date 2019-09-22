package com.drpicox.game.runners;

import com.drpicox.game.maps.MapController;
import com.drpicox.game.messages.MessageController;
import org.springframework.stereotype.Component;

@Component
public class CR100ClearMessages implements CommandRunner {

    private MessageController messageController;

    public CR100ClearMessages(MessageController messageController) {
        this.messageController = messageController;
    }
    @Override
    public int getPriority() {
        return 100;
    }

    @Override
    public void run() {
        messageController.clear();
    }
}
