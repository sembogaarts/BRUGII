package com.tosad.brg.api.domain.template;

public class Template {
    private String name;
    private String script;
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
