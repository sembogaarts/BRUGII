package com.tosad.brg.api;

import com.tosad.brg.api.domain.BusinessRule;
import com.tosad.brg.api.domain.BusinessRuleTag;
import com.tosad.brg.api.domain.Template;
import com.tosad.brg.api.domain.TemplateTag;
import com.tosad.brg.api.domain.templatetagtypes.TemplateTagTypeList;
import com.tosad.brg.api.domain.templatetagtypes.TemplateTagTypeString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TemplateTag templateTag = new TemplateTag("table", new TemplateTagTypeString());
        TemplateTag templateTag1 = new TemplateTag("attribute", new TemplateTagTypeList());

        BusinessRuleTag businessRuleTag = new BusinessRuleTag("sem", templateTag);
        BusinessRuleTag businessRuleTag1 = new BusinessRuleTag("getal", templateTag1);

        HashMap<TemplateTag, BusinessRuleTag> businessRuleTagHashMap = new HashMap<>();
        businessRuleTagHashMap.put(businessRuleTag.getTemplateTag(), businessRuleTag);
        businessRuleTagHashMap.put(businessRuleTag1.getTemplateTag(), businessRuleTag1);

        Template template = new Template("businessRule", "SELECT * FROM {{table}} WHERE {{attribute}} = 0", "blabla");
        BusinessRule businessRule = new BusinessRule("naam", template, businessRuleTagHashMap);

        System.out.println(businessRule.generateCode());
    }
}
