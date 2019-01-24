package com.tosad.brm.web.api;

import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRuleTag;
import com.tosad.brm.web.hibernate.domain.template.TemplateTag;
import com.tosad.brm.web.hibernate.domain.type.TemplateTagType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleTagJSON implements ApiJSON {
    public static JSONObject generate(BusinessRuleTag businessRuleTag) {
        JSONObject jsonObject = generateJSONObject(businessRuleTag);
//        jsonObject.put("value", templateTag.getTemplateTagType().getDefaultValue());
        return jsonObject;
    }
//
//    public static JSONArray generateFromList(List<TemplateTag> templateTagList) {
//        JSONArray jsonArray = new JSONArray();
//        List<TemplateTag> loopList = new ArrayList<>();
//        boolean isLoop = false;
//        for (TemplateTag templateTag : templateTagList) {
//            if (TemplateTagType.LOOP == templateTag.getTemplateTagType()) {
//                isLoop = !isLoop;
//                continue;
//            }
//
//            if (isLoop) {
//                loopList.add(templateTag);
//            } else {
//                jsonArray.add(generate(templateTag));
//            }
//        }
//        if (!loopList.isEmpty()) {
//            jsonArray.add(generateLoop(loopList));
//        }
//
//        return jsonArray;
//    }

    private static JSONObject generateLoopObject(TemplateTag templateTag) {
//        JSONObject jsonObject = generateJSONObject(templateTag);
//        jsonObject.put("value", new JSONArray());
//        return jsonObject;
        return new JSONObject();
    }

    static JSONObject generateJSONObject(BusinessRuleTag businessRuleTag) {
        JSONObject jsonObject = new JSONObject();
//
//        jsonObject.put("id", templateTag.id);
//        jsonObject.put("name", templateTag.key);
//        jsonObject.put("type", templateTag.templateTagType);
        return jsonObject;
    }
}