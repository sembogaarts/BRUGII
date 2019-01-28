package com.tosad.brm.web.taskSpecific.api.json;

import com.tosad.brm.web.domain.businessRule.BusinessRuleTag;
import com.tosad.brm.web.domain.template.TemplateTag;
import com.tosad.brm.web.domain.type.TemplateTagType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class TemplateTagJSON implements ApiJSON {
    public static JSONObject generate(TemplateTag templateTag) {
        JSONObject jsonObject = generateJSONObject(templateTag);
        jsonObject.put("value", templateTag.getTemplateTagType().getDefaultValue());
        return jsonObject;
    }

    public static JSONObject generate(TemplateTag templateTag, BusinessRuleTag businessRuleTag) {
        JSONObject jsonObject = generateJSONObject(templateTag, businessRuleTag);
        jsonObject.put("value", businessRuleTag.value);
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

    public static JSONArray generateFromList(HashMap<BusinessRuleTag, TemplateTag> hashMapList) {
        JSONArray jsonArray = new JSONArray();
        HashMap<BusinessRuleTag, TemplateTag> loopList = new HashMap<>();
        boolean isLoop = false;
        for (Map.Entry<BusinessRuleTag, TemplateTag> entry : hashMapList.entrySet()) {
            BusinessRuleTag businessRuleTag = entry.getKey();
            TemplateTag templateTag = entry.getValue();
            if (TemplateTagType.LOOP == templateTag.getTemplateTagType()) {
                isLoop = !isLoop;
                continue;
            }

            if (isLoop) {
                loopList.put(businessRuleTag, templateTag);
            } else {
                jsonArray.add(generate(templateTag, businessRuleTag));
            }
        }

        if (!loopList.isEmpty()) {
            jsonArray.add(generateLoop(loopList));
        }

        return jsonArray;
    }

    public static JSONObject generateLoop(List<TemplateTag> templateTags) {
        JSONArray jsonArray = new JSONArray();
        templateTags.forEach(templateTag -> jsonArray.add(generateLoopObject(templateTag)));
        JSONObject jsonObject = generateLoopJSONObject();
        jsonObject.put("fields", jsonArray);

        return jsonObject;

    }

    public static JSONObject generateLoop(HashMap<BusinessRuleTag, TemplateTag> hashMapList) {
        JSONArray jsonArray = new JSONArray();
        hashMapList.forEach((businessRuleTag, templateTag) -> jsonArray.add(generateLoopObject(templateTag, businessRuleTag)));
        JSONObject jsonObject = generateLoopJSONObject();
        jsonObject.put("fields", jsonArray);
        return jsonObject;
    }

    private static JSONObject generateLoopJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", TemplateTagType.LOOP.type);
        jsonObject.put("type", TemplateTagType.LOOP.type);
        return jsonObject;
    }

    private static JSONObject generateLoopObject(TemplateTag templateTag, BusinessRuleTag businessRuleTag) {
        JSONObject jsonObject = generateJSONObject(templateTag);
        jsonObject.put("value", businessRuleTag.value);
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

    static JSONObject generateJSONObject(TemplateTag templateTag, BusinessRuleTag businessRuleTag) {
        JSONObject jsonObject = generateJSONObject(templateTag);
        jsonObject.put("id", businessRuleTag.id);
        return jsonObject;
    }
}