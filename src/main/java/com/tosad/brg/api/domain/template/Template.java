package com.tosad.brg.api.domain.template;

import javax.persistence.*;

@Entity
@Table(name = "TEMPLATE")
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="TEMPLATE_SEQUENCE", sequenceName="TEMPLATE_SEQUENCE", allocationSize=1)
    public int id;

    @Column(name = "name")
    private String name;

    @Column(name = "script")
    private String script;

    @Column(name = "prefix")
    private String prefix;

    private DatabaseType databaseType;

    public Template(String name, String script, String prefix, DatabaseType databaseType) {
        this.name = name;
        this.script = script;
        this.prefix = prefix;
        this.databaseType = databaseType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public DatabaseType getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(DatabaseType databaseType) {
        this.databaseType = databaseType;
    }
}
