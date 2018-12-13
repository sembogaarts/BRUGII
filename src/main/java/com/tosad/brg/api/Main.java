package com.tosad.brg.api;

import com.tosad.brg.api.models.BusinessRule;
import com.tosad.brg.api.models.BusinessRuleTag;
import com.tosad.brg.api.models.Template;
import com.tosad.brg.api.models.TemplateTag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        TemplateTag templateTag = new TemplateTag("table");
        List<TemplateTag> templateTags = new ArrayList<TemplateTag>(Arrays.asList(templateTag));

        BusinessRuleTag businessRuleTag = new BusinessRuleTag("moussa");
        List<BusinessRuleTag> businessRuleTags = new ArrayList<BusinessRuleTag>(Arrays.asList(businessRuleTag));

        Template template = new Template("businessRule", "SELECT * FROM {{table}}", "blabla", templateTags);
        BusinessRule businessRule = new BusinessRule("naam", template, businessRuleTags);

        System.out.println(businessRule.generateCode());
    }
}
