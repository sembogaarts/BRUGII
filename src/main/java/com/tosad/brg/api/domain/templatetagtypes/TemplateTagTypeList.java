package com.tosad.brg.api.domain.templatetagtypes;

public class TemplateTagTypeList implements TemplateTagType {
    TemplateTagTypes type = TemplateTagTypes.LIST;

    public TemplateTagTypeList() {

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