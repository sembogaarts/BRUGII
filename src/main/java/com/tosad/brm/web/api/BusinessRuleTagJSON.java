package com.tosad.brm.web.api;

import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRule;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRuleTag;
import com.tosad.brm.web.hibernate.domain.template.TemplateTag;
import com.tosad.brm.web.hibernate.domain.type.TemplateTagType;
import com.tosad.brm.web.persistence.TemplateTagPersitence;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class BusinessRuleTagJSON implements ApiJSON {
    public static JSONObject generate(BusinessRuleTag businessRuleTag) {
        JSONObject jsonObject = generateJSONObject(businessRuleTag);
//        jsonObject.put("value", templateTag.getTemplateTagType().getDefaultValue());
        return jsonObject;
    }

    private static JSONObject generateLoopObject(TemplateTag templateTag) {
        return new JSONObject();
    }

    static JSONObject generateJSONObject(BusinessRuleTag businessRuleTag) {
        JSONObject jsonObject = new JSONObject();
        return jsonObject;
    }

    public static List<BusinessRuleTag> parseTags(JSONArray jsonArray, BusinessRule businessRule) {
        List<BusinessRuleTag> businessRuleTagList = new ArrayList<>();
        for (Object item : jsonArray) {
            JSONObject jsonItem = (JSONObject) item;
            String value = (String) jsonItem.get("value");
            int id = ((Long) jsonItem.get("id")).intValue();
            TemplateTag templateTag = TemplateTagPersitence.getById(id);
            businessRuleTagList.add(new BusinessRuleTag(value, templateTag, businessRule));
        }

        return businessRuleTagList;
    }
}