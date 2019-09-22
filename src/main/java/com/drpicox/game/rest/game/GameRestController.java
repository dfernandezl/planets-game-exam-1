package com.drpicox.game.rest.game;

import com.drpicox.game.entities.EntityController;
import com.drpicox.game.game.GameController;
import com.drpicox.game.game.SuccessResponse;
import com.drpicox.game.maps.builders.MapBuilderController;
import com.drpicox.game.maps.builders.MapConfiguration;
import com.drpicox.game.players.PlayerController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/game")
public class GameRestController {

    private EntityController entityController;
    private GameController gameController;
    private PlayerController playerController;
    private MapBuilderController mapBuilderController;

    public GameRestController(EntityController entityController, GameController gameController, PlayerController playerController, MapBuilderController mapBuilderController) {
        this.entityController = entityController;
        this.gameController = gameController;
        this.playerController = playerController;
        this.mapBuilderController = mapBuilderController;
    }

    @PutMapping
    public Object replace(@RequestBody MapConfiguration mapConfiguration) {
        mapBuilderController.build(mapConfiguration);

        if (!mapConfiguration.hasPlayers()) {
            return SuccessResponse.INSTANCE;
        }

        var playerId = mapConfiguration.getPlayer(1).getPlayerId();
        var player = playerController.get(playerId);
        var response = gameController.getPlayerGame(player);
        return response;
    }
}
