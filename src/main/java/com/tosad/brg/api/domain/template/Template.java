package com.tosad.brg.api.domain.template;

import com.tosad.brg.api.domain.businessRule.BusinessRuleType;
import com.tosad.brg.api.taskSpecific.Project;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TEMPLATE")
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "TEMPLATE_SEQUENCE", sequenceName = "TEMPLATE_SEQUENCE", allocationSize = 1)
    public int id;

    @Column(name = "databasetype")
    private String databaseType;

    @ManyToOne
    @JoinColumn(name = "businessruletype_id", nullable = false)
    private BusinessRuleType businessRuleType;

    @Column(name = "name")
    private String name;

    @Column(name = "script")
    private String script;

    @Column(name = "prefix")
    private String prefix;

    public Template(String name, String script, String prefix, BusinessRuleType businessRuleType, DatabaseType databaseType) {
        this.name = name;
        this.script = script;
        this.prefix = prefix;
        this.businessRuleType = businessRuleType;
        this.databaseType = databaseType.toString();
    }

//    public DatabaseType getDatabaseType() {
//        return databaseType;
//    }

//    public void setDatabaseType(DatabaseType databaseType) {
//        this.databaseType = databaseType;
//    }
}
