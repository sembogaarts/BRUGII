package com.tosad.brm.web.taskSpecific.api;

import com.tosad.brm.web.domain.businessRule.BusinessRule;
import com.tosad.brm.web.domain.businessRule.BusinessRuleTag;
import com.tosad.brm.web.domain.template.TemplateTag;
import com.tosad.brm.web.domain.type.TemplateTagType;
import com.tosad.brm.web.taskSpecific.persistence.TemplateTagPersistence;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class BusinessRuleTagJSON implements ApiJSON {
    public static List<BusinessRuleTag> parseTags(JSONArray jsonArray, BusinessRule businessRule) {
        List<BusinessRuleTag> businessRuleTagList = new ArrayList<>();
        for (Object item : jsonArray) {
            JSONObject jsonItem = (JSONObject) item;
            TemplateTagType templateTagType = TemplateTagType.getTypeByText(parseValue(jsonItem.get("type")));
            if (TemplateTagType.LOOP == templateTagType) {
                for (Object loopItem : (JSONArray) jsonItem.get("fields")) {
                    JSONObject jsonLoopItem = (JSONObject) loopItem;
                    businessRuleTagList.add(parseItem(jsonLoopItem, businessRule));
                }
            } else {
                businessRuleTagList.add(parseItem(jsonItem, businessRule));
            }
        }

        return businessRuleTagList;
    }

    private static BusinessRuleTag parseItem(JSONObject jsonItem, BusinessRule businessRule) {
        String value = parseValue(jsonItem.get("value"));
        int id = ((Long) jsonItem.get("id")).intValue();
        TemplateTag templateTag = TemplateTagPersistence.getById(id);
        return new BusinessRuleTag(value, templateTag, businessRule);
    }

    private static String parseValue(Object item) {
        return String.valueOf(item);
    }
}