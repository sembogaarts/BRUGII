package com.tosad.brg.domain.type;


import java.io.Serializable;

public enum TemplateTagType implements Serializable {
    STRING("string"),
    NAME("name"),
    LIST("list") {
        @Override
        public String parseValue(String value) {
            value = value.replace("[", "(");
            value = value.replace("]", ")");
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
    FOREACHROW("foreachrow") {
        @Override
        public String parseValue(String value) {
            return value.equals("true") ? "FOR EACH ROW" : "";
        }
    },
    BINDER("binder"),
    LOOP("loop"),
    NUMBER("number"),
    TABLE("table"),
    DYNAMIC("dynamic"),
    STATE("state"),         // Trigger - Before / After
    EVENT("event"),         // Trigger - Insert / Update
    COLUMN("column"),
    BOOLEAN("boolean") {
        @Override
        public String parseValue(String value) {
            return value.equals("true") ? "NOT" : "";
        }
    },
    UNKNOWN("unknown");

    public String type;


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
