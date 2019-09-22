package com.drpicox.game.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@Embeddable
public class Coordinates implements Serializable {
    @Column(name = "aRow")
    private int row;
    @Column(name = "aColumn")
    private int column;

    public Coordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public Coordinates() {}

    public Map<String, Object> getJson() {
        return new LinkedHashMap<>() {{
            put("row", row);
            put("column", column);
        }};
    }

    public Coordinates move(String direction) {
        switch (direction) {
            case "down": return new Coordinates(row + 1, column);
            case "up": return new Coordinates(row - 1, column);
            case "left": return new Coordinates(row, column - 1);
            /*case "right":*/ default: return new Coordinates(row, column + 1);
        }
    }
}
