package com.tosad.brg.taskSpecific.api;

import com.tosad.brg.domain.BusinessRuleTag;
import com.tosad.brg.domain.Template;
import com.tosad.brg.domain.TemplateTag;

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
