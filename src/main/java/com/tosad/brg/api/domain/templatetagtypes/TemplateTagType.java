package com.tosad.brg.api.domain.templatetagtypes;


import java.io.Serializable;

public enum TemplateTagType implements Serializable {
    STRING("string"),
    LIST("list") {
        @Override
        public String parseValue(String value) {
            return value;
        }
    },
    OPERATOR("operator"),
    NUMBER("number"),
    TABLE("table"),
    COLUMN("column"),
    BOOLEAN("boolean"),
    UNKNOWN("unkown");

    private String type;


    TemplateTagType(String type) {
        this.type = type;
    }

    public static TemplateTagType getTypeByText(String type) {
        for (TemplateTagType templateTagTypes : values()) {
            if (templateTagTypes.type.equals(type)) {
                return templateTagTypes;
            }
        }
        return UNKNOWN;
    }

    public String parseValue(String value) {
        return value;
    }
}
