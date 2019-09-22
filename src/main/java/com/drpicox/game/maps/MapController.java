package com.drpicox.game.maps;

import com.drpicox.game.players.Player;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MapController {

    private MapRepository mapRepository;

    public MapController(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    private Map get(String mapId) {
        return mapRepository.findById(mapId).orElse(null);
    }

    public Map get() {
        return get("uniq");
    }

    public Map create(String mapId, List<Player> players) {
        var map = new Map(mapId, players);
        mapRepository.save(map);
        return map;
    }

    public void clear() {
        mapRepository.deleteAll();
    }

    public Player getNextPlayer(Player player) {
        return get().getNextPlayer(player);
    }

    public void increaseTurnNumber() {
        var map = get();
        map.increaseTurnNumber();
        mapRepository.save(map);
    }

    public void addPlayer(Player player) {
        var map = get();
        map.addPlayer(player);
        mapRepository.save(map);
    }
}
