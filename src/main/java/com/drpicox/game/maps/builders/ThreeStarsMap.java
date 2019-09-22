package com.drpicox.game.maps.builders;

import com.drpicox.game.entities.Coordinates;
import com.drpicox.game.maps.Map;
import com.drpicox.game.stars.StarController;
import org.springframework.stereotype.Component;

@Component
public class ThreeStarsMap implements MapBuilder {

    private StarController starController;

    public ThreeStarsMap(StarController starController) {
        this.starController = starController;
    }

    @Override
    public String getName() {
        return "ThreeStars";
    }

    @Override
    public void build(MapConfiguration mapConfiguration, Map map) {
        starController.createHomeworld("Bajor", new Coordinates(3, 3));
        starController.createHomeworld("Cardassia", new Coordinates(3, 4));
        starController.createStar("Earth", new Coordinates(4, 3));
    }
}
