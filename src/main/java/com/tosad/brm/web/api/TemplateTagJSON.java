package com.tosad.brm.web.api;

import com.tosad.brm.web.hibernate.domain.template.TemplateTag;
import com.tosad.brm.web.hibernate.domain.type.TemplateTagType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TemplateTagJSON implements ApiJSON {
    public static JSONObject generate(TemplateTag templateTag) {
        JSONObject jsonObject = generateJSONObject(templateTag);
        jsonObject.put("value", templateTag.getTemplateTagType().getDefaultValue());
        return jsonObject;
    }

    public static JSONArray generateFromList(List<TemplateTag> templateTagList) {
        JSONArray jsonArray = new JSONArray();
        List<TemplateTag> loopList = new ArrayList<>();
        boolean isLoop = false;
        for (TemplateTag templateTag : templateTagList) {
            if (TemplateTagType.LOOP == templateTag.getTemplateTagType()) {
                isLoop = !isLoop;
                continue;
            }

            if (isLoop) {
                loopList.add(templateTag);
            } else {
                jsonArray.add(generate(templateTag));
            }
        }
        if (!loopList.isEmpty()) {
            jsonArray.add(generateLoop(loopList));
        }

        return jsonArray;
    }

    public static JSONObject generateLoop(List<TemplateTag> templateTags) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        templateTags.forEach(templateTag -> jsonArray.add(generateLoopObject(templateTag)));
        jsonObject.put("name", TemplateTagType.LOOP.type);
        jsonObject.put("type", TemplateTagType.LOOP.type);
        jsonObject.put("fields", jsonArray);

        return jsonObject;

    }

    private static JSONObject generateLoopObject(TemplateTag templateTag) {
        JSONObject jsonObject = generateJSONObject(templateTag);
        jsonObject.put("value", new JSONArray());
        return jsonObject;
    }

    static JSONObject generateJSONObject(TemplateTag templateTag) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", templateTag.id);
        jsonObject.put("name", templateTag.key);
        jsonObject.put("type", templateTag.templateTagType);
        return jsonObject;
    }
}