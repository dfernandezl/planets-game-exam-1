package com.drpicox.game.maps.builders;

import com.drpicox.game.commands.CommandController;
import com.drpicox.game.entities.EntityController;
import com.drpicox.game.maps.MapController;
import com.drpicox.game.messages.MessageController;
import com.drpicox.game.players.Player;
import com.drpicox.game.players.PlayerController;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapBuilderController {

    private MapBuilderCollector mapBuilderCollector;
    private EntityController entityController;
    private PlayerController playerController;
    private CommandController commandController;
    private MessageController messageController;
    private MapController mapController;

    public MapBuilderController(MapBuilderCollector mapBuilderCollector, EntityController entityController, PlayerController playerController, CommandController commandController, MessageController messageController, MapController mapController) {
        this.mapBuilderCollector = mapBuilderCollector;
        this.entityController = entityController;
        this.playerController = playerController;
        this.commandController = commandController;
        this.messageController = messageController;
        this.mapController = mapController;
    }

    public void build(MapConfiguration mapConfiguration) {
        MapBuilder builder = getMapBuilder(mapConfiguration);

        clearMap();
        var players = createPlayers(mapConfiguration);
        var map = mapController.create("uniq", players);

        builder.build(mapConfiguration, map);
    }

    private List<Player> createPlayers(MapConfiguration mapConfiguration) {
        return mapConfiguration.getPlayers().stream()
                .map(config -> {
                    var player = playerController.create(config.getPlayerId(), config.getCanonicalRace());
                    messageController.sendMessage(player, "Welcome");
                    return player;
                })
                .collect(Collectors.toList());
    }

    private void clearMap() {
        messageController.clear();
        commandController.clear();
        entityController.clear();
        mapController.clear();
        playerController.clear();
    }

    private MapBuilder getMapBuilder(MapConfiguration mapConfiguration) {
        var mapCode = mapConfiguration.getMapCode();
        var builder = mapBuilderCollector.get(mapCode);
        if (builder == null)
            throw new MapCodeNotFoundException(mapCode);
        return builder;
    }
}
