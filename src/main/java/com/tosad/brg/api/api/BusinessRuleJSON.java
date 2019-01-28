package com.tosad.brg.api.api;

import com.tosad.brg.api.hibernate.domain.businessRule.BusinessRuleTag;
import com.tosad.brg.api.hibernate.domain.template.Template;
import com.tosad.brg.api.hibernate.domain.template.TemplateTag;

import java.util.HashMap;
import java.util.Map;

public class BusinessRuleJSON {

    public static String generateSQL(Template template, HashMap<BusinessRuleTag, TemplateTag> businessRuleHashMap) {
        String code = template.script;

        for (Map.Entry<BusinessRuleTag, TemplateTag> entry : businessRuleHashMap.entrySet()) {
            BusinessRuleTag businessRuleTag = entry.getKey();
            TemplateTag templateTag = entry.getValue();
            code = code.replace(templateTag.getTemplateKey(), businessRuleTag.getValue());
        }

        return code;
    }


}
