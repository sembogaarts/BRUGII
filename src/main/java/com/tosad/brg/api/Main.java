package com.tosad.brg.api;

import com.tosad.brg.api.domain.*;
import com.tosad.brg.api.domain.BusinessRule;
import com.tosad.brg.api.domain.templatetagtypes.TemplateTagType;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Project project = new Project("test", "127.0.0.1", "rj", "33", 3323, DatabaseType.ORACLE, new ArrayList<Table>());

        TemplateTag templateTag = new TemplateTag("table", TemplateTagType.STRING);
        TemplateTag templateTag1 = new TemplateTag("attribute", TemplateTagType.LIST);

        BusinessRuleTag businessRuleTag = new BusinessRuleTag("sem", templateTag);
        BusinessRuleTag businessRuleTag1 = new BusinessRuleTag("getal", templateTag1);

        HashMap<TemplateTag, BusinessRuleTag> businessRuleTagHashMap = new HashMap<>();
        businessRuleTagHashMap.put(businessRuleTag.getTemplateTag(), businessRuleTag);
        businessRuleTagHashMap.put(businessRuleTag1.getTemplateTag(), businessRuleTag1);

        Template template = new Template("businessRule", "SELECT * FROM {{table}} WHERE {{attribute}} = 0", "blabla", DatabaseType.ORACLE);
        BusinessRule businessRule = new BusinessRule("naam", BusinessRuleType.TUPLE_COMPARE_RULE, template, businessRuleTagHashMap);

//        Connection connection = (Connection) project.getDatabaseConnection().getConnection();
        System.out.println(businessRule.generateCode());
    }
}
