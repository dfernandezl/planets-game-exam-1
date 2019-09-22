package com.drpicox.game.commands;

import com.drpicox.game.entities.Entity;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandController {

    private CommandRepository commandRepository;

    public CommandController(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }


    public void deleteAllByPlayer(Player player) {
        var commands = commandRepository.findAllByPlayer(player);
        commandRepository.deleteAll(commands);
    }

    public void createCommand(Player player, Entity entity, String type, String value) {
        commandRepository.save(new Command(player, entity, type, value));
    }

    public List<Command> listAllByPlayer(Player player) {
        return commandRepository.findAllByPlayer(player);
    }

    public void clear() {
        commandRepository.deleteAll();
    }

    public List<Command> listAllByType(String type) {
        return commandRepository.findAllByTypeOrderByEntityAsc(type);
    }
}
