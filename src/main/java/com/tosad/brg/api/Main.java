package com.tosad.brg.api;

import com.tosad.brg.api.domain.businessRule.BusinessRule;
import com.tosad.brg.api.domain.businessRule.BusinessRuleTag;
import com.tosad.brg.api.domain.businessRule.BusinessRuleType;
import com.tosad.brg.api.domain.template.DatabaseType;
import com.tosad.brg.api.domain.template.Template;
import com.tosad.brg.api.domain.template.TemplateTag;
import com.tosad.brg.api.taskSpecific.Column;
import com.tosad.brg.api.taskSpecific.Project;
import com.tosad.brg.api.taskSpecific.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    SessionFactory factory;
    Session session;

    public static void main(String[] args) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        hibernateUtils.boot();
        Session session = hibernateUtils.getSession();


        Transaction t = session.beginTransaction();

        Project project = new Project(1, "BRG", "localhost", "cursist", "cursist2321", 8521, DatabaseType.ORACLE, null);
        session.save(project);

        Table table = new Table(project, "gebruikers");
        session.save(table);

        Column column = new Column("gebruikersnaam", table);
        session.save(column);

        BusinessRuleType businessRuleType = new BusinessRuleType(1, "attribute_range_rule");
        session.save(businessRuleType);

        BusinessRuleType businessRuleType2 = new BusinessRuleType(2, "attribute_compare_rule");
        session.save(businessRuleType2);

        BusinessRuleType businessRuleType3 = new BusinessRuleType(3, "attribute_list_rule");
        session.save(businessRuleType3);

        BusinessRuleType businessRuleType4 = new BusinessRuleType(4, "attribute_other_rule");
        session.save(businessRuleType4);

        BusinessRuleType businessRuleType5 = new BusinessRuleType(5, "tuple_compare_rule");
        session.save(businessRuleType5);

        BusinessRuleType businessRuleType6 = new BusinessRuleType(6, "tuple_other_rule");
        session.save(businessRuleType6);

        BusinessRuleType businessRuleType7 = new BusinessRuleType(7, "inter_entity_compare_rule");
        session.save(businessRuleType7);

        BusinessRuleType businessRuleType8 = new BusinessRuleType(8, "entity_other_rule");
        session.save(businessRuleType8);

        BusinessRuleType businessRuleType9 = new BusinessRuleType(9, "modify_rule");
        session.save(businessRuleType9);

        Template template = new Template(1, "testnaam", "", "", businessRuleType, DatabaseType.ORACLE);
        session.save(template);

//        Template template_arng = new Template("BRG_(ENTITEIT)_CNS/TRG(RULE)_01", "", "arng", businessRuleType, DatabaseType.ORACLE);
//        session.save(template_arng);

        BusinessRule businessRule = new BusinessRule("testrule", businessRuleType, null, null);
        session.save(businessRule);

        TemplateTag templateTag = new TemplateTag("key", "type", template);
        session.save(templateTag);

        BusinessRuleTag businessRuleTag = new BusinessRuleTag(1, "gebruikers", templateTag, businessRule);
        session.save(businessRuleTag);

        t.commit();

        hibernateUtils.close();
//        BusinessRuleTag businessRuleTag1 = new BusinessRuleTag("id", new TemplateTag("COLUMN", TemplateTagType.COLUMN));
//        BusinessRuleTag businessRuleTag2 = new BusinessRuleTag("=", new TemplateTag("OPERATOR", TemplateTagType.OPERATOR));
//        BusinessRuleTag businessRuleTag3 = new BusinessRuleTag("Y", new TemplateTag("CHECK", TemplateTagType.STRING));

//        HashMap<TemplateTag, BusinessRuleTag> businessRuleTagHashMap = new HashMap<>();
//        businessRuleTagHashMap.put(businessRuleTag.getTemplateTag(), businessRuleTag);
//        businessRuleTagHashMap.put(businessRuleTag1.getTemplateTag(), businessRuleTag1);
//        businessRuleTagHashMap.put(businessRuleTag2.getTemplateTag(), businessRuleTag2);
//        businessRuleTagHashMap.put(businessRuleTag3.getTemplateTag(), businessRuleTag3);
//
//        TemplateFactory templateFactory = new TemplateFactory();
//
//
//        BusinessRule businessRule = new BusinessRule(
//                "tuple_compare_rule_test_rule",
//                BusinessRuleType.TUPLE_COMPARE_RULE,
//                null,
//                businessRuleTagHashMap);
//        businessRule.setTemplate(templateFactory.getTemplateByBusinessRuleType(businessRule.getBusinessRuleType()));
//
//        BusinessRule businessRule1 = new BusinessRule(
//                "attribute_range_rule_test_rule",
//                BusinessRuleType.ATTRIBUTE_RANGE_RULE,
//                null,
//                businessRuleTagHashMap);
//        businessRule1.setTemplate(templateFactory.getTemplateByBusinessRuleType(businessRule1.getBusinessRuleType()));
//
//
//        BusinessRule businessRule2 = new BusinessRule(
//                "attribute_range_rule_test_rule",
//                BusinessRuleType.ATTRIBUTE_COMPARE_RULE,
//                null,
//                businessRuleTagHashMap);
//        businessRule2.setTemplate(templateFactory.getTemplateByBusinessRuleType(businessRule2.getBusinessRuleType()));

//        System.out.println(businessRule.generateCode());
//        System.out.println(businessRule1.generateCode());
//        System.out.println(businessRule2.generateCode());
    }
}


