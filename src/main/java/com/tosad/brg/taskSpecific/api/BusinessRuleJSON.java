package com.tosad.brg.taskSpecific.api;

import com.tosad.brg.domain.businessRule.BusinessRule;
import com.tosad.brg.domain.businessRule.BusinessRuleTag;
import com.tosad.brg.domain.template.Template;
import com.tosad.brg.domain.template.TemplateTag;
import com.tosad.brg.domain.type.TemplateTagType;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class BusinessRuleJSON {

    public static String generateSQL(BusinessRule businessRule, Template template, HashMap<BusinessRuleTag, TemplateTag> businessRuleHashMap) {
        String code = template.script;

        for (Map.Entry<BusinessRuleTag, TemplateTag> entry : businessRuleHashMap.entrySet()) {
            BusinessRuleTag businessRuleTag = entry.getKey();
            TemplateTag templateTag = entry.getValue();
            if (templateTag.getTemplateTagType() == TemplateTagType.NAME) {
                code = code.replace(templateTag.getTemplateKey(), businessRule.name);
            } else {
                code = code.replace(templateTag.getTemplateKey(), templateTag.getTemplateTagType().parseValue(businessRuleTag.value));
            }
        }

        return code;
    }

    public static JSONObject generateJSON(BusinessRule businessRule, Template template, HashMap<BusinessRuleTag, TemplateTag> businessRuleHashMap) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", businessRule.name);
        jsonObject.put("code", BusinessRuleJSON.generateSQL(businessRule, template, businessRuleHashMap));

        return jsonObject;
    }


}
