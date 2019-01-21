package com.tosad.brg.api;

import com.tosad.brg.api.domain.businessRule.BusinessRule;
import com.tosad.brg.api.domain.businessRule.BusinessRuleTag;
import com.tosad.brg.api.domain.businessRule.BusinessRuleType;
import com.tosad.brg.api.domain.template.DatabaseType;
import com.tosad.brg.api.domain.template.Template;
import com.tosad.brg.api.domain.template.TemplateTag;
import com.tosad.brg.api.domain.type.TemplateTagType;
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

        Project project = new Project("BRG", "localhost", "cursist", "cursist2321", 8521, null, null);
        Table table = new Table("gebruikers");
        Column column = new Column("gebruikersnaam");
        BusinessRuleTag businessRuleTag = new BusinessRuleTag(1, "gebruikers", null);
        BusinessRule businessRule = new BusinessRule("testrule", null, null, null);
        BusinessRuleType businessRuleType = new BusinessRuleType("attribute_range_rule");
        Template template = new Template("testnaam", "", "", null);
        TemplateTag templateTag = new TemplateTag("key", "type");
//        TemplateTagType templateTagType = new TemplateTagType("");
//        DatabaseType databaseType = new DatabaseType("Oracle");
//        BusinessRuleTag businessRule = (BusinessRuleTag) session.get(BusinessRuleTag.class, 1);
//        System.out.println(businessRule.getValue());

        Transaction t = session.beginTransaction();
        session.save(project);
        session.save(table);
        session.save(column);
        session.save(businessRule);
        session.save(businessRuleTag);
        session.save(businessRuleType);
        session.save(template);
        session.save(templateTag);

        t.commit();

        hibernateUtils.close();
//        toolDatabase.getConnection()
//        Project project = new Project("test", "ondora04.hu.nl", "cursist", "cursist2321", 8521, DatabaseType.ORACLE, new ArrayList<Table>());

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


