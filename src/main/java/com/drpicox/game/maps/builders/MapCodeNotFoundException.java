package com.drpicox.game.maps.builders;

import com.drpicox.game.rest.GlobalRestException;

public class MapCodeNotFoundException extends GlobalRestException {
    public MapCodeNotFoundException(String mapCode) {
        super("Wrong map code, it was not found: " + mapCode);
    }
}
