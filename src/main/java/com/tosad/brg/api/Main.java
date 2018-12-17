package com.tosad.brg.api;

import com.tosad.brg.api.models.BusinessRule;
import com.tosad.brg.api.models.BusinessRuleTag;
import com.tosad.brg.api.models.Template;
import com.tosad.brg.api.models.TemplateTag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TemplateTag templateTag = new TemplateTag("table");
        TemplateTag templateTag1 = new TemplateTag("attribute");
        List<TemplateTag> templateTags = new ArrayList<>(Arrays.asList(templateTag, templateTag1));

        BusinessRuleTag businessRuleTag = new BusinessRuleTag("sem");
        BusinessRuleTag businessRuleTag1 = new BusinessRuleTag("getal");
        List<BusinessRuleTag> businessRuleTags = new ArrayList<>(Arrays.asList(businessRuleTag, businessRuleTag1));

        Template template = new Template("businessRule", "SELECT * FROM {{table}} WHERE {{attribute}} = 0", "blabla", templateTags);
        BusinessRule businessRule = new BusinessRule("naam", template, businessRuleTags);

        System.out.println(businessRule.generateCode());
    }
}
