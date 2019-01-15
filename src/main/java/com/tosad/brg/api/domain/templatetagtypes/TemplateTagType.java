package com.tosad.brg.api.domain.templatetagtypes;

public interface TemplateTagType {
    TemplateTagTypes getType();

    String parseValue(String value);
}
