package com.drpicox.game.maps.builders;

import com.drpicox.game.maps.Map;

public interface MapBuilder {

    String getName();

    void build(MapConfiguration mapConfiguration, Map map);

}
