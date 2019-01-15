package com.tosad.brg.api.domain.templatetagtypes;

public class TemplateTagTypeString implements TemplateTagType {
    TemplateTagTypes type = TemplateTagTypes.STRING;

    public TemplateTagTypeString() {

    }

    @Override
    public TemplateTagTypes getType() {
        return type;
    }

    @Override
    public String parseValue(String value) {
        return value;
    }
}
