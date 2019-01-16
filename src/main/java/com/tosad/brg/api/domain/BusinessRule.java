package com.tosad.brg.api.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusinessRule {

    private String name;
    private Template template;
    private BusinessRuleType businessRuleType;
    HashMap<TemplateTag, BusinessRuleTag> businessRuleTagHashMap;


    public BusinessRule(String name, BusinessRuleType businessRuleType, Template template, HashMap<TemplateTag, BusinessRuleTag> businessRuleTagHashMap) {
        this.name = name;
        this.businessRuleType = businessRuleType;
        this.template = template;
        this.businessRuleTagHashMap = businessRuleTagHashMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public String generateCode() {
        String code = template.getScript();

        for (Map.Entry<TemplateTag, BusinessRuleTag> entry : businessRuleTagHashMap.entrySet()) {
            TemplateTag templateTag = entry.getKey();
            BusinessRuleTag businessRuleTag = entry.getValue();
            code = code.replace(templateTag.getTemplateKey(), businessRuleTag.getValue());
        }

        return code;
    }
}
