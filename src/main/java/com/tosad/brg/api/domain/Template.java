package com.tosad.brg.api.domain;

import java.util.List;

public class Template {
    private String name;
    private String script;
    private String prefix;

    public Template(String name, String script, String prefix) {
        this.name = name;
        this.script = script;
        this.prefix = prefix;
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
}
