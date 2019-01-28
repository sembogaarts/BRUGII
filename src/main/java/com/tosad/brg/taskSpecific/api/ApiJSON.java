package com.tosad.brg.taskSpecific.api;

import org.json.simple.JSONObject;

public interface ApiJSON {
    static JSONObject generate() {
        return new JSONObject();
    }
}
