package com.tosad.brm.web.taskSpecific.api.json;

import org.json.simple.JSONObject;

public interface ApiJSON {
    static JSONObject generate() {
        return new JSONObject();
    }
}
