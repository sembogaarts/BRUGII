package com.tosad.brm.web.taskSpecific.api.json;

import com.tosad.brm.web.domain.template.Template;
import org.json.simple.JSONObject;

public class TemplateJSON implements ApiJSON {
    public static JSONObject generate(Template template) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", template.id);
        jsonObject.put("name", template.name);
        jsonObject.put("script", template.script);
        return jsonObject;
    }
}
