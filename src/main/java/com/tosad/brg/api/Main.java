package com.tosad.brg.api;

import com.tosad.brg.api.domain.businessRule.BusinessRule;
import com.tosad.brg.api.domain.businessRule.BusinessRuleTag;
import com.tosad.brg.api.domain.businessRule.BusinessRuleType;
import com.tosad.brg.api.domain.template.Template;
import com.tosad.brg.api.domain.template.TemplateTag;
import com.tosad.brg.api.domain.type.TemplateTagType;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        Project project = new Project("test", "127.0.0.1", "rj", "33", 3323, DatabaseType.ORACLE, new ArrayList<Table>());

        BusinessRuleTag businessRuleTag = new BusinessRuleTag("gebruikers", new TemplateTag("table", TemplateTagType.TABLE));
        BusinessRuleTag businessRuleTag1 = new BusinessRuleTag("id", new TemplateTag("column", TemplateTagType.COLUMN));
        BusinessRuleTag businessRuleTag2 = new BusinessRuleTag("=", new TemplateTag("operator", TemplateTagType.OPERATOR));
        BusinessRuleTag businessRuleTag3 = new BusinessRuleTag("Y", new TemplateTag("check", TemplateTagType.STRING));

        HashMap<TemplateTag, BusinessRuleTag> businessRuleTagHashMap = new HashMap<>();
        businessRuleTagHashMap.put(businessRuleTag.getTemplateTag(), businessRuleTag);
        businessRuleTagHashMap.put(businessRuleTag1.getTemplateTag(), businessRuleTag1);
        businessRuleTagHashMap.put(businessRuleTag2.getTemplateTag(), businessRuleTag2);
        businessRuleTagHashMap.put(businessRuleTag3.getTemplateTag(), businessRuleTag3);


        Template template = new Template("businessRule", "ALTER TABLE {{table}} ADD CONSTRAINT compare_rule_name check ({{column}} {{operator}} '{{check}}');", "blabla", DatabaseType.ORACLE);
        BusinessRule businessRule = new BusinessRule("naam", BusinessRuleType.TUPLE_COMPARE_RULE, template, businessRuleTagHashMap);

        System.out.println(businessRule.generateCode());
    }
}
