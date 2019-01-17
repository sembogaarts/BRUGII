package com.tosad.brg.api.domain.businessRule;

import com.tosad.brg.api.domain.template.TemplateTag;

public class BusinessRuleTag {
    public String value;
    private TemplateTag templateTag;

    public BusinessRuleTag(String value, TemplateTag templateTag) {
        this.value = value;
        this.templateTag = templateTag;
    }

    public String getValue() {
        return templateTag.getTemplateTagType().parseValue(value);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TemplateTag getTemplateTag() {
        return this.templateTag;
    }
}
