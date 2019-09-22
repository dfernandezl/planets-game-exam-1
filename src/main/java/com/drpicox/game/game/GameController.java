package com.drpicox.game.game;

import com.drpicox.game.commands.CommandController;
import com.drpicox.game.entities.EntityController;
import com.drpicox.game.maps.MapController;
import com.drpicox.game.messages.MessageController;
import com.drpicox.game.players.Player;
import com.drpicox.game.runners.CommandRunnerController;
import com.drpicox.game.stars.StarController;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class GameController {

    private EntityController entityController;
    private StarController starController;
    private CommandController commandController;
    private MessageController messageController;
    private CommandRunnerController commandRunnerController;
    private MapController mapController;

    public GameController(EntityController entityController, StarController starController, CommandController commandController, MessageController messageController, CommandRunnerController commandRunnerController, MapController mapController) {
        this.entityController = entityController;
        this.starController = starController;
        this.commandController = commandController;
        this.messageController = messageController;
        this.commandRunnerController = commandRunnerController;
        this.mapController = mapController;
    }

    public PlayerGameResponse getPlayerGame(Player player) {
        var stars = starController.listAll();
        var owns = entityController.listAllOwnedBy(player);
        var coordinatesSet = owns.stream().map(e -> e.getCoordinates()).collect(Collectors.toSet());
        var seen = entityController.listAllIn(coordinatesSet);
        var commands = commandController.listAllByPlayer(player);
        var messages = messageController.listAllByPlayer(player);
        var map = mapController.get();

        var gameResponse = new PlayerGameResponse(player, map);
        stars.forEach(s -> gameResponse.addEntity(s.getDistantJson()));
        seen.forEach(e -> gameResponse.addEntity(e.getVisibleJson()));
        owns.forEach(e -> gameResponse.addEntity(e.getOwnJson()));
        commands.forEach(c -> gameResponse.addCommand(c.getJson()));
        messages.forEach(m -> gameResponse.addMessage(m.getJson()));

        return gameResponse;
    }

    public void compile() {
        commandRunnerController.runAll();
        commandController.clear();
    }
}
