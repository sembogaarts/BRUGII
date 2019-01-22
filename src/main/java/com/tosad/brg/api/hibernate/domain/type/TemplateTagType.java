package com.tosad.brg.api.hibernate.domain.type;


import java.io.Serializable;

public enum TemplateTagType implements Serializable {
    STRING("string"),
    LIST("list") {
        @Override
        public String parseValue(String value) {
            return value;
        }
    },
    OPERATOR("operator") {
        @Override
        public String parseValue(String value) {
            return value;
        }
    },
    L_OPERATOR("l_operator") {
        @Override
        public String parseValue(String value) {
            return value;
        }
    },
    NUMBER("number"),
    TABLE("table"),
    BETWEEN("between"),     // Trigger - Between / Not between
    DYNAMIC("dynamic"),
    STATE("state"),         // Trigger - Before / After
    EVENT("event"),         // Trigger - Insert / Update
    EACH_ROW("each_row"),   // Trigger - Before each row
    COLUMN("column"),
    BOOLEAN("boolean"),
    UNKNOWN("unknown");

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

    public String getType() {
        return type;
    }

    public String parseValue(String value) {
        return value;
    }
}
