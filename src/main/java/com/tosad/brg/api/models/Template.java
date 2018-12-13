package com.tosad.brg.api.models;

import java.util.ArrayList;
import java.util.List;

public class Template {
    private String name;
    private String script;
    private String prefix;
    private List<TemplateTag> templateTagArrayList;

    public Template(String name, String script, String prefix, List<TemplateTag> templateTagArrayList) {
        this.name = name;
        this.script = script;
        this.prefix = prefix;
        this.templateTagArrayList = templateTagArrayList;
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

    public List<TemplateTag> getTemplateTagArrayList() {
        return templateTagArrayList;
    }

    public void setTemplateTagArrayList(List<TemplateTag> templateTagArrayList) {
        this.templateTagArrayList = templateTagArrayList;
    }
}
