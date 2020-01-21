package com.drpicox.game.rest.players;

import com.drpicox.game.commands.CommandController;
import com.drpicox.game.entities.EntityController;
import com.drpicox.game.game.GameController;
import com.drpicox.game.game.PlayerGameResponse;
import com.drpicox.game.maps.MapController;
import com.drpicox.game.maps.builders.MapBuilderCollector;
import com.drpicox.game.players.Player;
import com.drpicox.game.players.PlayerController;
import com.drpicox.game.players.Race;
import com.drpicox.game.stars.StarController;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerRestController {

    private EntityController entityController;
    private PlayerController playerController;
    private StarController starController;
    private GameController gameController;
    private CommandController commandController;
    private MapController mapController;

    public PlayerRestController(EntityController entityController, PlayerController playerController, StarController starController, GameController gameController, CommandController commandController, MapController mapController) {
        this.entityController = entityController;
        this.playerController = playerController;
        this.starController = starController;
        this.gameController = gameController;
        this.commandController = commandController;
        this.mapController = mapController;
    }

    @GetMapping("/{playerId}")
    public PlayerGameResponse login(@PathVariable String playerId) {
        var player = playerController.get(playerId);
        if (player == null) {
            player = playerController.create(playerId, Race.HUMAN);
            starController.assignHomeworld(player);
            mapController.addPlayer(player);
        }

        var response = gameController.getPlayerGame(player);
        return response;
    }

    @PutMapping("/{playerId}/commands")
    public PlayerGameResponse replaceCommands(@PathVariable String playerId, @RequestBody List<CommandForm> commands) {
        var player = playerController.get(playerId);
        saveCommands(commands, player);

        var response = gameController.getPlayerGame(player);
        return response;
    }

    private void saveCommands(@RequestBody List<CommandForm> commands, Player player) {
        commandController.deleteAllByPlayer(player);
        for (var command : commands) {
            var entity = entityController.get(command.getEntityId());
            var type = command.getType();
            var value = command.getValue();
            commandController.createCommand(player, entity, type, value);
        }
    }

    @PutMapping("/{playerId}/next")
    public PlayerGameResponse nextPlayer(@PathVariable String playerId, @RequestBody List<CommandForm> commands) {
        var player = playerController.get(playerId);
        saveCommands(commands, player);

        var nextPlayer = mapController.getNextPlayer(player);
        var response = gameController.getPlayerGame(nextPlayer);
        return response;
    }

    @PostMapping("/{playerId}/compile")
    public PlayerGameResponse compileGame(@PathVariable String playerId, @RequestBody List<CommandForm> commands) {
        var player = playerController.get(playerId);
        saveCommands(commands, player);
        gameController.compile();

        var response = gameController.getPlayerGame(player);
        return response;
    }
}
