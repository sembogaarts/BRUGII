package com.tosad.brg;

import com.tosad.brg.dataAccess.DatabaseConnection;
import com.tosad.brg.dataAccess.OracleDatabaseConnection;
import com.tosad.brg.domain.businessRule.BusinessRuleType;
import com.tosad.brg.domain.template.DatabaseType;
import com.tosad.brg.domain.template.Template;
import com.tosad.brg.domain.template.TemplateTag;
import com.tosad.brg.domain.type.TemplateTagType;
import com.tosad.brg.domain.project.Column;
import com.tosad.brg.domain.project.Project;
import com.tosad.brg.domain.project.Table;
import com.tosad.brg.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    SessionFactory factory;
    Session session;

    public static void main(String[] args) {
        HibernateUtils.getSessionFactory();
        Session session = HibernateUtils.getSession();

        Transaction t = session.beginTransaction();

        Project project = new Project(1, "BRG", "174.138.0.100", "admin", "a72c23455018edf0648592d865b355a49121697731bfe6c2", 3306, DatabaseType.MYSQL, null);
        session.save(project);

        Table factuur = new Table(project, "Factuur");
        session.save(factuur);
        session.save(new Column("id", "number", factuur));
        session.save(new Column("bedrag", "number", factuur));
        session.save(new Column("persoon_id", "number", factuur));

        Table gebruiker = new Table(project, "Gebruiker");
        session.save(gebruiker);
        session.save(new Column("id", "number", gebruiker));
        session.save(new Column("naam", "string", gebruiker));
        session.save(new Column("leeftijd", "number", gebruiker));
        session.save(new Column("email", "string", gebruiker));
        session.save(new Column("wachtwoord", "string", gebruiker));
        session.save(new Column("saldo", "number", gebruiker));

        Table post = new Table(project, "Post");
        session.save(post);
        session.save(new Column("id", "number", post));
        session.save(new Column("name", "string", post));
        session.save(new Column("title", "string", post));
        
        Table product = new Table(project, "Product");
        session.save(product);
        session.save(new Column("id", "number", product));
        session.save(new Column("name", "string", product));
        session.save(new Column("inkoopprijs", "number", product));
        session.save(new Column("verkoopprijs", "number", product));


        /*
         * attribute_range_rule
         * */
        BusinessRuleType attribute_range_rule = new BusinessRuleType(1, "Attribute Range Rule");
        session.save(attribute_range_rule);
        Template arng_template = new Template(1, "brg_gebruiker_cns_arng_01", "ALTER TABLE {{ TABLE }} ADD CONSTRAINT {{ NAME }} CHECK ( {{ COLUMN }} {{ NOT }} BETWEEN {{ NUMBER_1 }} AND {{ NUMBER_2 }} )", "arng", attribute_range_rule, DatabaseType.ORACLE);
        session.save(arng_template);
        session.save(new TemplateTag("TABLE", TemplateTagType.TABLE, arng_template));
        session.save(new TemplateTag("NAME", TemplateTagType.NAME, arng_template));
        session.save(new TemplateTag("COLUMN", TemplateTagType.COLUMN, arng_template));
        session.save(new TemplateTag("NUMBER_1", TemplateTagType.NUMBER, arng_template));
        session.save(new TemplateTag("NUMBER_2", TemplateTagType.NUMBER, arng_template));
        session.save(new TemplateTag("NOT", TemplateTagType.BOOLEAN, arng_template));

        /*
         * attribute_range_rule_advanced
         * */
        BusinessRuleType attribute_range_rule_advanced = new BusinessRuleType(2, "Attribute Range Rule (Advanced)");
        session.save(attribute_range_rule_advanced);
        Template arng_template_advanced = new Template(2, "brg_gebruiker_cns_arng_02", "ALTER TABLE {{ TABLE }} ADD CONSTRAINT {{ NAME }} CHECK ( {{ LOOP }} {{ COLUMN }} {{ NOT }} BETWEEN {{ NUMBER_1 }} AND {{ NUMBER_2 }} {{ BINDER }} {{ ENDLOOP }} )", "arng", attribute_range_rule_advanced, DatabaseType.ORACLE);
        session.save(arng_template_advanced);
        session.save(new TemplateTag("TABLE", TemplateTagType.TABLE, arng_template_advanced));
        session.save(new TemplateTag("NAME", TemplateTagType.NAME, arng_template_advanced));
        session.save(new TemplateTag("LOOP", TemplateTagType.LOOP, arng_template_advanced));
        session.save(new TemplateTag("COLUMN", TemplateTagType.COLUMN, arng_template_advanced));
        session.save(new TemplateTag("NUMBER_1", TemplateTagType.NUMBER, arng_template_advanced));
        session.save(new TemplateTag("NUMBER_2", TemplateTagType.NUMBER, arng_template_advanced));
        session.save(new TemplateTag("NOT", TemplateTagType.BOOLEAN, arng_template_advanced));
        session.save(new TemplateTag("BINDER", TemplateTagType.BINDER, arng_template_advanced));
        session.save(new TemplateTag("ENDLOOP", TemplateTagType.LOOP, arng_template_advanced));

        /*
         * attribute_compare_rule
         * */
        BusinessRuleType attribute_compare_rule = new BusinessRuleType(3, "Attribute Compare Rule");
        session.save(attribute_compare_rule);
        Template acmp_template = new Template(3, "brg_gebruiker_cns_acmp_01", "ALTER TABLE {{ TABLE }} ADD CONSTRAINT {{ NAME }} CHECK ( {{ COLUMN }} {{ OPERATOR }} {{ VALUE }} )", "acmp", attribute_compare_rule, DatabaseType.ORACLE);
        session.save(acmp_template);
        session.save(new TemplateTag("TABLE", TemplateTagType.TABLE, acmp_template));
        session.save(new TemplateTag("NAME", TemplateTagType.NAME, acmp_template));
        session.save(new TemplateTag("COLUMN", TemplateTagType.COLUMN, acmp_template));
        session.save(new TemplateTag("OPERATOR", TemplateTagType.OPERATOR, acmp_template));
        session.save(new TemplateTag("VALUE", TemplateTagType.DYNAMIC, acmp_template));


        /*
         * attribute_compare_rule_advanced
         * */
        BusinessRuleType attribute_compare_rule_advanced = new BusinessRuleType(4, "Attribute Compare Rule (Advanced)");
        session.save(attribute_compare_rule_advanced);
        Template acmp_template_advanced = new Template(4, "brg_gebruiker_cns_acmp_02", "ALTER TABLE {{ TABLE }} ADD CONSTRAINT {{ NAME }} CHECK ( {{ LOOP }} {{ COLUMN }} {{ OPERATOR }} {{ VALUE }} {{ BINDER }} {{ ENDLOOP }} )", "acmp", attribute_compare_rule_advanced, DatabaseType.ORACLE);
        session.save(acmp_template_advanced);
        session.save(new TemplateTag("TABLE", TemplateTagType.TABLE, acmp_template_advanced));
        session.save(new TemplateTag("NAME", TemplateTagType.NAME, acmp_template_advanced));
        session.save(new TemplateTag("LOOP", TemplateTagType.LOOP, acmp_template_advanced));
        session.save(new TemplateTag("COLUMN", TemplateTagType.COLUMN, acmp_template_advanced));
        session.save(new TemplateTag("OPERATOR", TemplateTagType.OPERATOR, acmp_template_advanced));
        session.save(new TemplateTag("VALUE", TemplateTagType.DYNAMIC, acmp_template_advanced));
        session.save(new TemplateTag("BINDER", TemplateTagType.BINDER, acmp_template_advanced));
        session.save(new TemplateTag("ENDLOOP", TemplateTagType.LOOP, acmp_template_advanced));

        /*
         * tuple_compare_rule
         * */
        BusinessRuleType tuple_compare_rule = new BusinessRuleType(5, "Tuple Compare Rule");
        session.save(tuple_compare_rule);
        Template tcmp_template = new Template(5, "brg_gebruiker_cns_tcmp_01", "ALTER TABLE {{ TABLE }} ADD CONSTRAINT {{ NAME }} CHECK ( {{ COLUMN_1 }} {{ OPERATOR }} {{ COLUMN_2 }}  )", "tcmp", tuple_compare_rule, DatabaseType.ORACLE);
        session.save(tcmp_template);
        session.save(new TemplateTag("TABLE", TemplateTagType.TABLE, tcmp_template));
        session.save(new TemplateTag("NAME", TemplateTagType.NAME, tcmp_template));
        session.save(new TemplateTag("COLUMN_1", TemplateTagType.COLUMN, tcmp_template));
        session.save(new TemplateTag("OPERATOR", TemplateTagType.OPERATOR, tcmp_template));
        session.save(new TemplateTag("COLUMN_2", TemplateTagType.COLUMN, tcmp_template));

        /*
         * tuple_compare_rule_advanced
         * */
        BusinessRuleType tuple_compare_rule_advanced = new BusinessRuleType(6, "Tuple Compare Rule (Advanced)");
        session.save(tuple_compare_rule_advanced);
        Template tcmp_template_advanced = new Template(6, "brg_gebruiker_cns_tcmp_02", "ALTER TABLE {{ TABLE }} ADD CONSTRAINT {{ NAME }} CHECK ( {{ LOOP }} {{ COLUMN_1 }} {{ OPERATOR }} {{ COLUMN_2 }} {{ BINDER }} {{ ENDLOOP }} )", "tcmp", tuple_compare_rule_advanced, DatabaseType.ORACLE);
        session.save(tcmp_template_advanced);
        session.save(new TemplateTag("TABLE", TemplateTagType.TABLE, tcmp_template_advanced));
        session.save(new TemplateTag("NAME", TemplateTagType.NAME, tcmp_template_advanced));
        session.save(new TemplateTag("LOOP", TemplateTagType.LOOP, tcmp_template_advanced));
        session.save(new TemplateTag("COLUMN_1", TemplateTagType.COLUMN, tcmp_template_advanced));
        session.save(new TemplateTag("OPERATOR", TemplateTagType.OPERATOR, tcmp_template_advanced));
        session.save(new TemplateTag("COLUMN_2", TemplateTagType.COLUMN, tcmp_template_advanced));
        session.save(new TemplateTag("BINDER", TemplateTagType.BINDER, tcmp_template_advanced));
        session.save(new TemplateTag("ENDLOOP", TemplateTagType.LOOP, tcmp_template_advanced));

        /*
         * inter_entity_compare_rule
         * */
        BusinessRuleType inter_entity_compare_rule = new BusinessRuleType(7, "Inter Entity Rule");
        session.save(inter_entity_compare_rule);
        Template icmp_template = new Template(7, "brg_gebruiker_trg_icmp_01", "CREATE OR REPLACE TRIGGER {{ NAME }} {{ BEFORE/AFTER }} {{ EVENT }}  ON {{ TABLE_1 }} {{ FOR EACH ROW }} DECLARE BEGIN IF (SELECT {{COLUMN_2}} FROM {{TABLE_2}} {{OPERATOR}} :new.{{COLUMN1}})  THEN RAISE_APPLICATION_ERROR({{ERRCODE}}, {{ERRMESSAGE}});", "icmp", inter_entity_compare_rule, DatabaseType.ORACLE);
        session.save(icmp_template);
        session.save(new TemplateTag("NAME", TemplateTagType.NAME, icmp_template));
        session.save(new TemplateTag("BEFORE/AFTER", TemplateTagType.STATE, icmp_template));
        session.save(new TemplateTag("EVENT", TemplateTagType.EVENT, icmp_template));
        session.save(new TemplateTag("TABLE_1", TemplateTagType.TABLE, icmp_template));
        session.save(new TemplateTag("FOR EACH ROW", TemplateTagType.BOOLEAN, icmp_template));
        session.save(new TemplateTag("COLUMN_2", TemplateTagType.COLUMN, icmp_template));
        session.save(new TemplateTag("TABLE_2", TemplateTagType.TABLE, icmp_template));
        session.save(new TemplateTag("OPERATOR", TemplateTagType.OPERATOR, icmp_template));
        session.save(new TemplateTag("COLUMN_1", TemplateTagType.COLUMN, icmp_template));
        session.save(new TemplateTag("ERRCODE", TemplateTagType.STRING, icmp_template));
        session.save(new TemplateTag("ERRMESSAGE", TemplateTagType.STRING, icmp_template));

        /*
         * inter_entity_compare_rule_advanced
         * */
        BusinessRuleType inter_entity_compare_rule_advanced = new BusinessRuleType(8, "Inter Entity Rule (Advanced)");
        session.save(inter_entity_compare_rule_advanced);
        Template icmp_template_advanced = new Template(8, "brg_gebruiker_trg_icmp_02", "CREATE OR REPLACE TRIGGER {{ NAME }} {{ BEFORE/AFTER }} {{ EVENT }}  ON {{ TABLE_1 }} {{ FOR EACH ROW }} DECLARE BEGIN IF ( {{ LOOP }} SELECT {{COLUMN_2}} FROM {{TABLE_2}} {{OPERATOR}} :new.{{COLUMN1}} {{ BINDER }} {{ ENDLOOP }} )  THEN RAISE_APPLICATION_ERROR({{ERRCODE}}, {{ERRMESSAGE}});", "icmp", inter_entity_compare_rule_advanced, DatabaseType.ORACLE);
        session.save(icmp_template_advanced);
        session.save(new TemplateTag("NAME", TemplateTagType.NAME, icmp_template_advanced));
        session.save(new TemplateTag("BEFORE/AFTER", TemplateTagType.STATE, icmp_template_advanced));
        session.save(new TemplateTag("EVENT", TemplateTagType.EVENT, icmp_template_advanced));
        session.save(new TemplateTag("TABLE_1", TemplateTagType.TABLE, icmp_template_advanced));
        session.save(new TemplateTag("FOR EACH ROW", TemplateTagType.BOOLEAN, icmp_template_advanced));
        session.save(new TemplateTag("COLUMN_2", TemplateTagType.COLUMN, icmp_template_advanced));
        session.save(new TemplateTag("TABLE_2", TemplateTagType.TABLE, icmp_template_advanced));
        session.save(new TemplateTag("OPERATOR", TemplateTagType.OPERATOR, icmp_template_advanced));
        session.save(new TemplateTag("COLUMN_1", TemplateTagType.COLUMN, icmp_template_advanced));
        session.save(new TemplateTag("ERRCODE", TemplateTagType.STRING, icmp_template_advanced));
        session.save(new TemplateTag("ERRMESSAGE", TemplateTagType.STRING, icmp_template_advanced));

        /*
         * attribute_list_rule
         * */
        BusinessRuleType attribute_list_rule = new BusinessRuleType(9, "Attribute List Rule");
        session.save(attribute_list_rule);
        Template alis_template = new Template(9, "brg_gebruiker_trg_alis_01", "ALTER TABLE {{ TABLE }} ADD CONSTRAINT {{ NAME }} CHECK ( {{ COLUMN }} {{ NOT }} IN {{ LIST }} )", "alis", attribute_list_rule, DatabaseType.ORACLE);
        session.save(alis_template);
        session.save(new TemplateTag("TABLE", TemplateTagType.TABLE, alis_template));
        session.save(new TemplateTag("NAME", TemplateTagType.NAME, alis_template));
        session.save(new TemplateTag("LOOP", TemplateTagType.LOOP, alis_template));
        session.save(new TemplateTag("COLUMN", TemplateTagType.COLUMN, alis_template));
        session.save(new TemplateTag("NOT", TemplateTagType.BOOLEAN, alis_template));
        session.save(new TemplateTag("LIST", TemplateTagType.LIST, alis_template));
        session.save(new TemplateTag("BINDER", TemplateTagType.BINDER, alis_template));
        session.save(new TemplateTag("ENDLOOP", TemplateTagType.LOOP, alis_template));

        /*
         * attribute_list_rule_advanced
         * */
        BusinessRuleType attribute_list_rule_advanced = new BusinessRuleType(10, "Attribute List Rule (Advanced)");
        session.save(attribute_list_rule_advanced);
        Template alis_template_advanced = new Template(10, "brg_gebruiker_trg_alis_02", "ALTER TABLE {{ TABLE }} ADD CONSTRAINT {{ NAME }} CHECK ( {{ LOOP }}  {{ COLUMN }} {{ NOT }} IN {{ LIST }} {{ BINDER }} {{ ENDLOOP }} )", "alis", attribute_list_rule_advanced, DatabaseType.ORACLE);
        session.save(alis_template_advanced);
        session.save(new TemplateTag("TABLE", TemplateTagType.TABLE, alis_template_advanced));
        session.save(new TemplateTag("NAME", TemplateTagType.NAME, alis_template_advanced));
        session.save(new TemplateTag("LOOP", TemplateTagType.LOOP, alis_template_advanced));
        session.save(new TemplateTag("COLUMN", TemplateTagType.COLUMN, alis_template_advanced));
        session.save(new TemplateTag("NOT", TemplateTagType.BOOLEAN, alis_template_advanced));
        session.save(new TemplateTag("LIST", TemplateTagType.LIST, alis_template_advanced));
        session.save(new TemplateTag("BINDER", TemplateTagType.BINDER, alis_template_advanced));
        session.save(new TemplateTag("ENDLOOP", TemplateTagType.LOOP, alis_template_advanced));

        /*
         * entity_other_rule
         * */
        BusinessRuleType entity_other_rule = new BusinessRuleType(11, "Entity Other Rule");
        session.save(entity_other_rule);
        Template eoth_template = new Template(11, "brg_gebruiker_trg_eoth_01", "CREATE OR REPLACE TRIGGER {{ NAME }} {{ before/after }} {{ event }}  ON {{ TABLE_1 }} [[ FOR EACH ROW ]] DECLARE v_kolommen number; BEGIN SELECT COUNT(*) INTO v_kolommen FROM {{TABLE_2}}  WHERE {{TABLE_2}}.{{TABLE_2_ID}} = {{TABLE_1}}.{{TABLE_1_ID}} IF v_kolommen {{OPERATOR}} {{VALUE}} THEN RAISE_APPLICATION_ERROR({{errcode}}, {{errmessage}}); END;", "eoth", entity_other_rule, DatabaseType.ORACLE);
        session.save(eoth_template);
        session.save(new TemplateTag("NAME", TemplateTagType.NAME, eoth_template));
        session.save(new TemplateTag("BEFORE/AFTER", TemplateTagType.STATE, eoth_template));
        session.save(new TemplateTag("EVENT", TemplateTagType.EVENT, eoth_template));
        session.save(new TemplateTag("TABLE_1", TemplateTagType.TABLE, eoth_template));
        session.save(new TemplateTag("COLUMN_1", TemplateTagType.TABLE, eoth_template));
        session.save(new TemplateTag("FOR EACH ROW", TemplateTagType.BOOLEAN, eoth_template));
        session.save(new TemplateTag("TABLE_2", TemplateTagType.TABLE, eoth_template));
        session.save(new TemplateTag("COLUMN_2", TemplateTagType.TABLE, eoth_template));
        session.save(new TemplateTag("OPERATOR", TemplateTagType.OPERATOR, eoth_template));
        session.save(new TemplateTag("VALUE", TemplateTagType.DYNAMIC, eoth_template));
        session.save(new TemplateTag("ERRCODE", TemplateTagType.STRING, eoth_template));
        session.save(new TemplateTag("ERRMESSAGE", TemplateTagType.STRING, eoth_template));

        /*
         * entity_other_rule_advanced
         * */
        BusinessRuleType entity_other_rule_advanced = new BusinessRuleType(12, "Entity Other Rule (Advanced)");
        session.save(entity_other_rule_advanced);
        Template eoth_template_advanced = new Template(12, "brg_gebruiker_trg_eoth_02", "CREATE OR REPLACE TRIGGER {{ NAME }} {{ before/after }} {{ event }}  ON {{ TABLE_1 }} [[ FOR EACH ROW ]] DECLARE v_kolommen number; BEGIN SELECT COUNT(*) INTO v_kolommen FROM {{TABLE_2}}  WHERE {{TABLE_2}}.{{TABLE_2_ID}} = {{TABLE_1}}.{{TABLE_1_ID}} IF v_kolommen {{OPERATOR}} {{VALUE}} THEN RAISE_APPLICATION_ERROR({{errcode}}, {{errmessage}}); END;", "eoth", entity_other_rule_advanced, DatabaseType.ORACLE);
        session.save(eoth_template_advanced);
        session.save(new TemplateTag("NAME", TemplateTagType.NAME, eoth_template_advanced));
        session.save(new TemplateTag("BEFORE/AFTER", TemplateTagType.STATE, eoth_template_advanced));
        session.save(new TemplateTag("EVENT", TemplateTagType.EVENT, eoth_template_advanced));
        session.save(new TemplateTag("TABLE_1", TemplateTagType.TABLE, eoth_template_advanced));
        session.save(new TemplateTag("COLUMN_1", TemplateTagType.TABLE, eoth_template_advanced));
        session.save(new TemplateTag("FOR EACH ROW", TemplateTagType.BOOLEAN, eoth_template_advanced));
        session.save(new TemplateTag("TABLE_2", TemplateTagType.TABLE, eoth_template_advanced));
        session.save(new TemplateTag("LOOP", TemplateTagType.LOOP, eoth_template_advanced));
        session.save(new TemplateTag("COLUMN_2", TemplateTagType.TABLE, eoth_template_advanced));
        session.save(new TemplateTag("OPERATOR", TemplateTagType.OPERATOR, eoth_template_advanced));
        session.save(new TemplateTag("VALUE", TemplateTagType.DYNAMIC, eoth_template_advanced));
        session.save(new TemplateTag("BINDER", TemplateTagType.BINDER, eoth_template_advanced));
        session.save(new TemplateTag("ENDLOOP", TemplateTagType.LOOP, eoth_template_advanced));
        session.save(new TemplateTag("ERRCODE", TemplateTagType.STRING, eoth_template_advanced));
        session.save(new TemplateTag("ERRMESSAGE", TemplateTagType.STRING, eoth_template_advanced));

        /*
         * attribute_other_rule
         * */
        BusinessRuleType attribute_other_rule = new BusinessRuleType(13, "Attribute Other Rule");
        session.save(attribute_other_rule);
        Template aoth_template = new Template(13, "brg_gebruiker_trg_aoth_01", "ALTER TABLE {{ TABLE }} ADD CONSTRAINT {{ NAME }} CHECK(SUBSTR({{ COLUMN }},{{NUMBER_1}},{{NUMBER_2}}) [[ NOT ]] BETWEEN ({{ VALUE_1}} AND {{ VALUE_2}}))", "eoth", attribute_other_rule, DatabaseType.ORACLE);
        session.save(aoth_template);
        session.save(new TemplateTag("TABLE", TemplateTagType.TABLE, aoth_template));
        session.save(new TemplateTag("NAME", TemplateTagType.NAME, aoth_template));
        session.save(new TemplateTag("COLUMN", TemplateTagType.COLUMN, aoth_template));
        session.save(new TemplateTag("NUMBER_1", TemplateTagType.NUMBER, aoth_template));
        session.save(new TemplateTag("NUMBER_2", TemplateTagType.NUMBER, aoth_template));
        session.save(new TemplateTag("NOT", TemplateTagType.BOOLEAN, aoth_template));
        session.save(new TemplateTag("VALUE_1", TemplateTagType.DYNAMIC, aoth_template));
        session.save(new TemplateTag("VALUE_2", TemplateTagType.DYNAMIC, aoth_template));

        /*
         * attribute_other_rule_advanced
         * */
        BusinessRuleType attribute_other_rule_advanced = new BusinessRuleType(14, "Attribute Other Rule (Advanced)");
        session.save(attribute_other_rule_advanced);
        Template aoth_template_advanced = new Template(14, "brg_gebruiker_trg_aoth_02", "ALTER TABLE {{ TABLE }} ADD CONSTRAINT {{ NAME }} CHECK(SUBSTR({{ COLUMN }},{{NUMBER_1}},{{NUMBER_2}}) [[ NOT ]] BETWEEN ({{ VALUE_1}} AND {{ VALUE_2}}))", "eoth", attribute_other_rule_advanced, DatabaseType.ORACLE);
        session.save(aoth_template_advanced);
        session.save(new TemplateTag("TABLE", TemplateTagType.TABLE, aoth_template_advanced));
        session.save(new TemplateTag("NAME", TemplateTagType.NAME, aoth_template_advanced));
        session.save(new TemplateTag("LOOP", TemplateTagType.LOOP, aoth_template_advanced));
        session.save(new TemplateTag("COLUMN", TemplateTagType.COLUMN, aoth_template_advanced));
        session.save(new TemplateTag("NUMBER_1", TemplateTagType.NUMBER, aoth_template_advanced));
        session.save(new TemplateTag("NUMBER_2", TemplateTagType.NUMBER, aoth_template_advanced));
        session.save(new TemplateTag("NOT", TemplateTagType.BOOLEAN, aoth_template_advanced));
        session.save(new TemplateTag("VALUE_1", TemplateTagType.DYNAMIC, aoth_template_advanced));
        session.save(new TemplateTag("VALUE_2", TemplateTagType.DYNAMIC, aoth_template_advanced));
        session.save(new TemplateTag("BINDER", TemplateTagType.BINDER, aoth_template_advanced));
        session.save(new TemplateTag("ENDLOOP", TemplateTagType.LOOP, aoth_template_advanced));

        /*
         * tuple_other_rule
         * */
        BusinessRuleType tuple_other_rule = new BusinessRuleType(15, "Tuple Other Rule");
        session.save(tuple_other_rule);
        Template toth_template = new Template(15, "brg_gebruiker_trg_toth_01", "CREATE OR REPLACE TRIGGER {{ NAME }} {{ before/after }} {{ event }}  ON {{ TABLE_1 }} [[ FOR EACH ROW ]] DECLARE BEGIN IF :new.{{COLUMN_1}} {{OPERATOR}} {{VALUE_1}} THEN IF ! SUBSTR({{COLUMN_2}}, {{NUMBER_1}}, {{NUMBER_2}}) [[NOT]] BETWEEN({{VALUE_1}},{{VALUE_2}})) THEN RAISE_APPLICATION_ERROR({{errcode}}, {{errmessage}}); END;", "toth", tuple_other_rule, DatabaseType.ORACLE);
        session.save(toth_template);
        session.save(new TemplateTag("NAME", TemplateTagType.NAME, toth_template));
        session.save(new TemplateTag("BEFORE/AFTER", TemplateTagType.STATE, toth_template));
        session.save(new TemplateTag("EVENT", TemplateTagType.EVENT, toth_template));
        session.save(new TemplateTag("TABLE", TemplateTagType.TABLE, toth_template));
        session.save(new TemplateTag("COLUMN_1", TemplateTagType.COLUMN, toth_template));
        session.save(new TemplateTag("OPERATOR", TemplateTagType.OPERATOR, toth_template));
        session.save(new TemplateTag("VALUE_1", TemplateTagType.DYNAMIC, toth_template));
        session.save(new TemplateTag("COLUMN_2", TemplateTagType.COLUMN, toth_template));
        session.save(new TemplateTag("NUMBER_1", TemplateTagType.NUMBER, toth_template));
        session.save(new TemplateTag("NUMBER_2", TemplateTagType.NUMBER, toth_template));
        session.save(new TemplateTag("NOT", TemplateTagType.BOOLEAN, toth_template));
        session.save(new TemplateTag("VALUE_1", TemplateTagType.DYNAMIC, toth_template));
        session.save(new TemplateTag("VALUE_2", TemplateTagType.DYNAMIC, toth_template));
        session.save(new TemplateTag("ERRCODE", TemplateTagType.STRING, toth_template));
        session.save(new TemplateTag("ERRMESSAGE", TemplateTagType.STRING, toth_template));

        /*
         * tuple_other_rule_advanced
         * */
        BusinessRuleType tuple_other_rule_advanced = new BusinessRuleType(16, "Tuple Other Rule (Advanced)");
        session.save(tuple_other_rule_advanced);
        Template toth_template_advanced = new Template(16, "brg_gebruiker_trg_toth_02", "CREATE OR REPLACE TRIGGER {{ NAME }} {{ before/after }} {{ event }}  ON {{ TABLE_1 }} [[ FOR EACH ROW ]] DECLARE BEGIN IF :new.{{COLUMN_1}} {{OPERATOR}} {{VALUE_1}} THEN IF ! SUBSTR({{COLUMN_2}}, {{NUMBER_1}}, {{NUMBER_2}}) [[NOT]] BETWEEN({{VALUE_1}},{{VALUE_2}})) THEN RAISE_APPLICATION_ERROR({{errcode}}, {{errmessage}}); END;", "toth", tuple_other_rule_advanced, DatabaseType.ORACLE);
        session.save(toth_template_advanced);
        session.save(new TemplateTag("NAME", TemplateTagType.NAME, toth_template_advanced));
        session.save(new TemplateTag("BEFORE/AFTER", TemplateTagType.STATE, toth_template_advanced));
        session.save(new TemplateTag("EVENT", TemplateTagType.EVENT, toth_template_advanced));
        session.save(new TemplateTag("TABLE", TemplateTagType.TABLE, toth_template_advanced));
        session.save(new TemplateTag("COLUMN_1", TemplateTagType.COLUMN, toth_template_advanced));
        session.save(new TemplateTag("OPERATOR", TemplateTagType.OPERATOR, toth_template_advanced));
        session.save(new TemplateTag("VALUE_1", TemplateTagType.DYNAMIC, toth_template_advanced));
        session.save(new TemplateTag("LOOP", TemplateTagType.LOOP, toth_template_advanced));
        session.save(new TemplateTag("COLUMN_2", TemplateTagType.COLUMN, toth_template_advanced));
        session.save(new TemplateTag("NUMBER_1", TemplateTagType.NUMBER, toth_template_advanced));
        session.save(new TemplateTag("NUMBER_2", TemplateTagType.NUMBER, toth_template_advanced));
        session.save(new TemplateTag("NOT", TemplateTagType.BOOLEAN, toth_template_advanced));
        session.save(new TemplateTag("VALUE_1", TemplateTagType.DYNAMIC, toth_template_advanced));
        session.save(new TemplateTag("VALUE_2", TemplateTagType.DYNAMIC, toth_template_advanced));
        session.save(new TemplateTag("BINDER", TemplateTagType.BINDER, toth_template_advanced));
        session.save(new TemplateTag("ENDLOOP", TemplateTagType.LOOP, toth_template_advanced));
        session.save(new TemplateTag("ERRCODE", TemplateTagType.STRING, toth_template_advanced));
        session.save(new TemplateTag("ERRMESSAGE", TemplateTagType.STRING, toth_template_advanced));


        t.commit();

        HibernateUtils.close();
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

//        System.out.println(businessRule.generateCode());
//        System.out.println(businessRule1.generateCode());
//        System.out.println(businessRule2.generateCode());
    }
}


