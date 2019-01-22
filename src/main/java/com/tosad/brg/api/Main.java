package com.tosad.brg.api;

import com.tosad.brg.api.hibernate.HibernateUtils;
import com.tosad.brg.api.hibernate.domain.businessRule.BusinessRuleType;
import com.tosad.brg.api.hibernate.domain.template.DatabaseType;
import com.tosad.brg.api.hibernate.domain.template.Template;
import com.tosad.brg.api.hibernate.domain.template.TemplateTag;
import com.tosad.brg.api.hibernate.domain.type.TemplateTagType;
import com.tosad.brg.api.hibernate.taskSpecific.Column;
import com.tosad.brg.api.hibernate.taskSpecific.Project;
import com.tosad.brg.api.hibernate.taskSpecific.Table;
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

        /*
         * attribute_range_rule
         * */
        BusinessRuleType attribute_range_rule = new BusinessRuleType(1, "attribute_range_rule");
        session.save(attribute_range_rule);
        Template arng_template = new Template(1, "brg_gebruiker_cns_arng_01", "", "arng", attribute_range_rule, DatabaseType.ORACLE);
        session.save(arng_template);
        session.save(new TemplateTag("table", TemplateTagType.TABLE, arng_template));
        session.save(new TemplateTag("name", TemplateTagType.STRING, arng_template));
        session.save(new TemplateTag("column", TemplateTagType.COLUMN, arng_template));
        session.save(new TemplateTag("between", TemplateTagType.BETWEEN, arng_template));
        session.save(new TemplateTag("number_1", TemplateTagType.NUMBER, arng_template));
        session.save(new TemplateTag("operator", TemplateTagType.OPERATOR, arng_template));
        session.save(new TemplateTag("number_2", TemplateTagType.NUMBER, arng_template));

        /*
         * attribute_compare_rule
         * */
        BusinessRuleType attribute_compare_rule = new BusinessRuleType(2, "attribute_compare_rule");
        session.save(attribute_compare_rule);
        Template acmp_template = new Template(1, "brg_gebruiker_cns_acmp_01", "", "acmp", attribute_range_rule, DatabaseType.ORACLE);
        session.save(acmp_template);
        session.save(new TemplateTag("table", TemplateTagType.TABLE, acmp_template));
        session.save(new TemplateTag("name", TemplateTagType.STRING, acmp_template));
        session.save(new TemplateTag("column", TemplateTagType.COLUMN, acmp_template));
        session.save(new TemplateTag("operator", TemplateTagType.OPERATOR, acmp_template));
        session.save(new TemplateTag("value", TemplateTagType.DYNAMIC, acmp_template));

        /*
         * tuple_compare_rule
         * */
        BusinessRuleType tuple_compare_rule = new BusinessRuleType(3, "tuple_compare_rule");
        session.save(tuple_compare_rule);
        Template tcmp_template = new Template(2, "brg_gebruiker_cns_tcmp_01", "", "tcmp", tuple_compare_rule, DatabaseType.ORACLE);
        session.save(acmp_template);
        session.save(new TemplateTag("table", TemplateTagType.TABLE, tcmp_template));
        session.save(new TemplateTag("name", TemplateTagType.STRING, tcmp_template));
        session.save(new TemplateTag("column_1", TemplateTagType.COLUMN, tcmp_template));
        session.save(new TemplateTag("operator", TemplateTagType.OPERATOR, tcmp_template));
        session.save(new TemplateTag("column_2", TemplateTagType.COLUMN, tcmp_template));

        /*
         * inter_entity_compare_rule
         * */
        BusinessRuleType inter_entity_compare_rule = new BusinessRuleType(4, "inter_entity_compare_rule");
        session.save(inter_entity_compare_rule);
        Template icmp_template = new Template(3, "brg_gebruiker_trg_icmp_01", "", "icmp", tuple_compare_rule, DatabaseType.ORACLE);
        session.save(acmp_template);
        session.save(new TemplateTag("name", TemplateTagType.STRING, icmp_template));
        session.save(new TemplateTag("state", TemplateTagType.STATE, icmp_template));
        session.save(new TemplateTag("event", TemplateTagType.EVENT, icmp_template));
        session.save(new TemplateTag("table_1", TemplateTagType.TABLE, icmp_template));
        session.save(new TemplateTag("each_row", TemplateTagType.EACH_ROW, icmp_template));
        session.save(new TemplateTag("column_2", TemplateTagType.COLUMN, icmp_template));
        session.save(new TemplateTag("table_2", TemplateTagType.TABLE, icmp_template));
        session.save(new TemplateTag("operator", TemplateTagType.OPERATOR, icmp_template));
        session.save(new TemplateTag("column_1", TemplateTagType.COLUMN, icmp_template));
        session.save(new TemplateTag("errcode", TemplateTagType.STRING, icmp_template));
        session.save(new TemplateTag("errmessage", TemplateTagType.STRING, icmp_template));

//        BusinessRuleType attribute_list_rule = new BusinessRuleType(3, "attribute_list_rule");
//        session.save(attribute_list_rule);
//
//
//        BusinessRuleType businessRuleType4 = new BusinessRuleType(4, "attribute_other_rule");
//        session.save(businessRuleType4);
//
//        BusinessRuleType businessRuleType6 = new BusinessRuleType(6, "tuple_other_rule");
//        session.save(businessRuleType6);
//
//        BusinessRuleType businessRuleType7 = new BusinessRuleType(7, "inter_entity_compare_rule");
//        session.save(businessRuleType7);
//
//        BusinessRuleType businessRuleType8 = new BusinessRuleType(8, "entity_other_rule");
//        session.save(businessRuleType8);
//
//        BusinessRuleType businessRuleType9 = new BusinessRuleType(9, "modify_rule");
//        session.save(businessRuleType9);

//        Template template_arng = new Template("BRG_(ENTITEIT)_CNS/TRG(RULE)_01", "", "arng", businessRuleType, DatabaseType.ORACLE);
//        session.save(template_arng);


//        TemplateTag templateTag = new TemplateTag("key", "type", template);
//        session.save(templateTag);
//
//        BusinessRuleTag businessRuleTag = new BusinessRuleTag(1, "gebruikers", templateTag, businessRule);
//        session.save(businessRuleTag);

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


