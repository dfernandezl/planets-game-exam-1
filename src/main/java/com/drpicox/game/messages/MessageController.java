package com.drpicox.game.messages;

import com.drpicox.game.entities.Coordinates;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.List;

@Controller
public class MessageController {

    private MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> listAllByPlayer(Player player) {
        return messageRepository.findAllByPlayer(player);
    }

    public void clear() {
        messageRepository.deleteAll();
    }

    public void sendMessage(Player to, String text) {
        sendMessage(to, text, null);
    }
    public void sendMessage(Player to, String text, Coordinates coordinates) {
        var msg = new Message(to, text, coordinates);
        messageRepository.save(msg);
    }
}
