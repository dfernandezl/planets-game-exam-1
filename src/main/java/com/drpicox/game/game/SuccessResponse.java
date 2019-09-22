package com.drpicox.game.game;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public class SuccessResponse {

    public static final SuccessResponse INSTANCE = new SuccessResponse();
    private Map result = new HashMap<>();

    private SuccessResponse() {
        result.put("message", "success");
    }

    @JsonValue
    public Map getJsonObject() {
        return result;
    }
}
