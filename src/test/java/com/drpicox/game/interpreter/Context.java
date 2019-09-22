package com.drpicox.game.interpreter;

import com.drpicox.game.tools.Json;

import java.util.*;
import java.util.function.Consumer;

public class Context {
    private Map<String, Object> values = new LinkedHashMap<>();
    private List<Consumer<Context>> beforeEachs = new LinkedList<>();
    private List<Consumer<Context>> afterEachs = new LinkedList<>();
    private List<Consumer<Context>> afterAlls = new LinkedList<>();

    public void remove(String key) {
        values.remove(key);
    }
    public boolean has(String key) {
        return values.containsKey(key);
    }
    public Set<String> keys() {
        return values.keySet();
    }
    public <T> T get(String key) {
        return (T) values.get(key);
    }
    public <T> T get(Class<T> clazz) {
        return get(clazz.getName());
    }

    public void set(String key, Object value) {
        values.put(key, value);
    }
    public <T> void set(Class<T> clazz, T value) {
        this.set(clazz.getName(), value);
    }
    public void setJson(String key, String json) {
        this.set(key, new Json(json));
    }

    public <T> T wantFor(Class<T> clazz) {
        return wantFor(clazz.getName());
    }
    public <T> T wantFor(String key) {
        if (!values.containsKey(key))
            throw new IllegalArgumentException("Expected key '" + key + "' to appear inside the context but it does not.");

        return this.get(key);
    }
    public Json wantJson(String key) {
        if (!values.containsKey(key))
            throw new IllegalArgumentException("Expected key '" + key + "' to appear inside the context but it does not.");

        var value = (Json) this.get(key);
        return value;
    }

    public Context clone() {
        var result = new Context();
        result.values.putAll(this.values);
        result.beforeEachs.addAll(this.beforeEachs);
        result.afterEachs.addAll(this.afterEachs);
        return result;
    }

    public Context configure(Consumer<Context> configurator) {
        configurator.accept(this);
        return this;
    }

    public Context beforeEach(Consumer<Context> cb) {
        beforeEachs.add(cb);
        return this;
    }

    public void doBeforeEach() {
        beforeEachs.forEach(cb -> cb.accept(this));
    }

    public Context afterEach(Consumer<Context> cb) {
        afterEachs.add(cb);
        return this;
    }

    public void doAfterEach() {
        afterEachs.forEach(cb -> cb.accept(this));
    }

    public Context afterAll(Consumer<Context> cb) {
        afterAlls.add(cb);
        return this;
    }

    public void doAfterAll() {
        afterAlls.forEach(cb -> cb.accept(this));
    }


}
