package com.tosad.brg.api.domain.templatetagtypes;

import java.io.Serializable;

public enum TemplateTagTypes implements Serializable {
    STRING("string"),
    LIST("list"),
    OPERATOR("operator"),
    NUMBER("number"),
    TABLE("table"),
    COLUMN("column"),
    BOOLEAN("boolean"),
    UNKNOWN("unkown");

    private String type;


    TemplateTagTypes(String type) {
        this.type = type;
    }

    public static TemplateTagTypes getTypeByInstance(TemplateTagType templateTagType) {
        if (templateTagType instanceof TemplateTagTypeString) {
            return STRING;
        } else if (templateTagType instanceof TemplateTagTypeList) {
            return LIST;
        }
        return UNKNOWN;
    }


    public static TemplateTagTypes getTypeByText(String type) {
        for (TemplateTagTypes templateTagTypes : values()) {
            if (templateTagTypes.type.equals(type)) {
                return templateTagTypes;
            }
        }
        return UNKNOWN;
    }

    @Override
    public String toString() {
        return type;
    }
}