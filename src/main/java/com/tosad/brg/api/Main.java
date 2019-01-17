package com.tosad.brg.api;

import com.tosad.brg.api.domain.TemplateFactory;
import com.tosad.brg.api.domain.businessRule.BusinessRule;
import com.tosad.brg.api.domain.businessRule.BusinessRuleTag;
import com.tosad.brg.api.domain.businessRule.BusinessRuleType;
import com.tosad.brg.api.domain.template.DatabaseType;
import com.tosad.brg.api.domain.template.TemplateTag;
import com.tosad.brg.api.domain.type.TemplateTagType;
import com.tosad.brg.api.taskSpecific.Project;
import com.tosad.brg.api.taskSpecific.Table;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Project project = new Project("test", "ondora04.hu.nl", "cursist", "cursist2321", 8521, DatabaseType.ORACLE, new ArrayList<Table>());

        BusinessRuleTag businessRuleTag = new BusinessRuleTag("gebruikers", new TemplateTag("TABLE", TemplateTagType.TABLE));
        BusinessRuleTag businessRuleTag1 = new BusinessRuleTag("id", new TemplateTag("COLUMN", TemplateTagType.COLUMN));
        BusinessRuleTag businessRuleTag2 = new BusinessRuleTag("=", new TemplateTag("OPERATOR", TemplateTagType.OPERATOR));
        BusinessRuleTag businessRuleTag3 = new BusinessRuleTag("Y", new TemplateTag("CHECK", TemplateTagType.STRING));

        HashMap<TemplateTag, BusinessRuleTag> businessRuleTagHashMap = new HashMap<>();
        businessRuleTagHashMap.put(businessRuleTag.getTemplateTag(), businessRuleTag);
        businessRuleTagHashMap.put(businessRuleTag1.getTemplateTag(), businessRuleTag1);
        businessRuleTagHashMap.put(businessRuleTag2.getTemplateTag(), businessRuleTag2);
        businessRuleTagHashMap.put(businessRuleTag3.getTemplateTag(), businessRuleTag3);

        TemplateFactory templateFactory = new TemplateFactory();


        BusinessRule businessRule = new BusinessRule(
                "tuple_compare_rule_test_rule",
                BusinessRuleType.TUPLE_COMPARE_RULE,
                null,
                businessRuleTagHashMap);
        businessRule.setTemplate(templateFactory.getTemplateByBusinessRuleType(businessRule.getBusinessRuleType()));

        BusinessRule businessRule1 = new BusinessRule(
                "attribute_range_rule_test_rule",
                BusinessRuleType.ATTRIBUTE_RANGE_RULE,
                null,
                businessRuleTagHashMap);
        businessRule1.setTemplate(templateFactory.getTemplateByBusinessRuleType(businessRule1.getBusinessRuleType()));


        BusinessRule businessRule2 = new BusinessRule(
                "attribute_range_rule_test_rule",
                BusinessRuleType.ATTRIBUTE_COMPARE_RULE,
                null,
                businessRuleTagHashMap);
        businessRule2.setTemplate(templateFactory.getTemplateByBusinessRuleType(businessRule2.getBusinessRuleType()));

        System.out.println(businessRule.generateCode());
        System.out.println(businessRule1.generateCode());
        System.out.println(businessRule2.generateCode());
    }
}
