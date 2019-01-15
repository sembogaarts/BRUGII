package com.tosad.brg.api.domain;

import com.tosad.brg.api.domain.templatetagtypes.TemplateTagType;
import com.tosad.brg.api.domain.templatetagtypes.TemplateTagTypeString;

public class TemplateTag {
    private String key;
    private TemplateTagType templateTagType;

    public TemplateTag(String key, TemplateTagType templateTagType) {
        this.key = key;
        this.templateTagType = templateTagType;
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

    public TemplateTagType getTemplateTagType() {
        return templateTagType;
    }

    public void setTemplateTagType(TemplateTagType templateTagType) {
        this.templateTagType = templateTagType;
    }
}
