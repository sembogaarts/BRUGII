package com.tosad.brm.web.api;

import org.json.simple.JSONObject;

public interface ApiJSON {
    static JSONObject generate() {
        return new JSONObject();
    }
}
