package com.tustar.pattern.behavioral.interpreter;

import java.util.HashMap;

public class Context {
    private HashMap<String, String> map = new HashMap<>();

    public void assign(String key, String value) {
        map.put(key, value);
    }

    public String lookup(String key) {
        return map.get(key);
    }
}
