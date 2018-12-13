package com.tosad.brg.api.models;

public class TemplateTag {
    private String key;

    public TemplateTag(String key) {
        this.key = key;
    }

    public String getTemplateKey() {
        return String.format("{{%s}}", key);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
