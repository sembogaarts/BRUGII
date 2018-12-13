package com.tosad.brg.api.models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

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

    private HashMap<TemplateTag, BusinessRuleTag> getTemplateTagAndBusinessRuleTagHashMap() {
        templateTagHashMap = new HashMap<>();

        int bound = businessRuleTags.size();
        for (int i = 0; i < bound; i++) {
            BusinessRuleTag businessRuleTag = businessRuleTags.get(i);
            templateTagHashMap.put(template.getTemplateTagArrayList().get(i), businessRuleTag);
        }

        return templateTagHashMap;
    }

    public String generateCode() {
        String code = template.getScript();

        for (Map.Entry<TemplateTag, BusinessRuleTag> entry : getTemplateTagAndBusinessRuleTagHashMap().entrySet()) {
            TemplateTag templateTag = entry.getKey();
            BusinessRuleTag businessRuleTag = entry.getValue();
            code = code.replace(templateTag.getTemplateKey(), businessRuleTag.getValue());
        }

        return code;
    }
}
