package com.tosad.brm.web.api;

import com.tosad.brm.web.hibernate.domain.template.TemplateTag;
import org.json.simple.JSONObject;

public class TemplateTagJSON implements ApiJSON {
    public static JSONObject generate(TemplateTag templateTag) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", templateTag.id);
        jsonObject.put("key", templateTag.key);
        jsonObject.put("type", templateTag.templateTagType);
        return jsonObject;
    }
}