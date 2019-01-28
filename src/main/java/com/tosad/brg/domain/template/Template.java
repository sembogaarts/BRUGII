package com.tosad.brg.domain.template;

import com.tosad.brg.domain.businessRule.BusinessRuleType;

import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "TEMPLATE")
public class Template {
    @Id
    @SequenceGenerator(name = "TEMPLATE_SEQUENCE", sequenceName = "TEMPLATE_SEQUENCE", allocationSize = 1)
    public int id;

    @Column(name = "databasetype")
    public String databaseType;

    @ManyToOne
    @JoinColumn(name = "businessruletype_id", nullable = false)
    public BusinessRuleType businessRuleType;

    @Column(name = "name")
    public String name;

    @Column(name = "script")
    public String script;

    @Column(name = "prefix")
    public String prefix;

    public Template(int id, String name, String script, String prefix, BusinessRuleType businessRuleType, DatabaseType databaseType) {
        this.id = id;
        this.name = name;
        this.script = script;
        this.prefix = prefix;
        this.businessRuleType = businessRuleType;
        this.databaseType = databaseType.toString();
    }

    public Template() {

    }
//    public DatabaseType getDatabaseType() {
//        return databaseType;
//    }

//    public void setDatabaseType(DatabaseType databaseType) {
//        this.databaseType = databaseType;
//    }
}
