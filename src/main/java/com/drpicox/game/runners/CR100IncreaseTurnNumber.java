package com.drpicox.game.runners;

import com.drpicox.game.maps.MapController;
import com.drpicox.game.stars.StarController;
import org.springframework.stereotype.Component;

@Component
public class CR100IncreaseTurnNumber implements CommandRunner {

    private MapController mapController;

    public CR100IncreaseTurnNumber(MapController mapController) {
        this.mapController = mapController;
    }

    @Override
    public int getPriority() {
        return 100;
    }

    @Override
    public void run() {
        mapController.increaseTurnNumber();
    }
}
