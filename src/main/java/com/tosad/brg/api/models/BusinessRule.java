package com.tosad.brg.api.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusinessRule {

    private String name;
    private Template template;
    private List<BusinessRuleTag> businessRuleTags;

    HashMap<TemplateTag, BusinessRuleTag> templateTagHashMap;


    public BusinessRule(String naam, Template template, List<BusinessRuleTag> businessRuleTags) {
        this.name = name;
        this.template = template;
        this.businessRuleTags = businessRuleTags;
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
        templateTagHashMap = new HashMap<>();
        for (int i = 0; i < businessRuleTags.size(); i++) {
            BusinessRuleTag businessRuleTag = businessRuleTags.get(i);
            templateTagHashMap.put(template.getTemplateTagArrayList().get(i), businessRuleTag);
        }
        String newScript = template.getScript();

        for (Map.Entry<TemplateTag, BusinessRuleTag> entry : templateTagHashMap.entrySet()) {
            TemplateTag key = entry.getKey();
            BusinessRuleTag value = entry.getValue();
            newScript = newScript.replace(key.getKey(), value.getValue());
        }

        return newScript;
    }
}
