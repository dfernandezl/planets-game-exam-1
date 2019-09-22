package com.drpicox.game.interpreter;

import com.drpicox.game.tools.Json;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class Snapshot {

    private final String method;
    private final String url;
    private final Json request;
    private final List<Runnable> successCbs = new ArrayList<>();
    private final List<Runnable> failuresCbs = new ArrayList<>();
    private final List<Runnable> responsesCbs = new ArrayList<>();
    private Json response;
    private int status;

    public Snapshot(String method, String url, Json request) {
        this.method = method;
        this.url = url;
        this.request = request;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public Json getRequest() {
        return request;
    }

    public void onSuccess(Runnable cb) {
        successCbs.add(cb);
    }
    public void onFailure(Runnable cb) {
        failuresCbs.add(cb);
    }
    public void onResponse(Runnable cb) {
        responsesCbs.add(cb);
    }

    public void setResponse(int status, String response) {
        this.status = status;
        this.response = new Json(response);

        var callbacks = (200 <= status && status < 300 ? successCbs : failuresCbs);
        callbacks.stream().forEach(s -> s.run());
        responsesCbs.stream().forEach(s -> s.run());

    }

    public Json getResponse() {
        return response;
    }

    public int getStatus() {
        return status;
    }


    @JsonValue
    public JsonObject getJsonValue() {
        var request = new JsonObject();
        request.addProperty("method", method);
        request.addProperty("url", url);
        request.add("body", this.request != null ? this.request.getElement() : JsonNull.INSTANCE);

        var response = new JsonObject();
        response.addProperty("status", status);
        response.add("body", this.response != null ? this.response.getElement() : JsonNull.INSTANCE);

        var result = new JsonObject();
        result.add("request", request);
        result.add("response", response);

        return result;
    }
}
