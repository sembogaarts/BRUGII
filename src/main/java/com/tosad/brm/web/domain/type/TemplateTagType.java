package com.tosad.brm.web.domain.type;


import org.json.simple.JSONArray;

import java.io.Serializable;

public enum TemplateTagType implements Serializable {
    STRING("string"),
    LIST("list") {
        @Override
        public Object getDefaultValue() {
            return new JSONArray();
        }
    },
    OPERATOR("operator"),
    L_OPERATOR("l_operator"),
    LOOP("loop"),
    NUMBER("number") {
        @Override
        public Object parseValue(String value) {
            return Integer.parseInt(value);
        }
    },
    TABLE("table"),
    DYNAMIC("dynamic"),
    STATE("state"),         // Trigger - Before / After
    EVENT("event"),         // Trigger - Insert / Update
    COLUMN("column"),
    BOOLEAN("boolean") {
        @Override
        public Object getDefaultValue() {
            return false;
        }

        @Override
        public Object parseValue(String value) {
            return value.equals("true");
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

    public Object parseValue(String value) {
        return value;
    }

    public Object getDefaultValue() {
        return "";
    }
}
