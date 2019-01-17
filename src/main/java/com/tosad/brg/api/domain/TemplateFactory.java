package com.tosad.brg.api.domain;

public class TemplateFactory {
    public Template getTemplateByBusinessRuleType(BusinessRuleType businessRuleType) {
        String value = "";
        switch (businessRuleType) {
            case TUPLE_COMPARE_RULE:
                value = "ALTER TABLE {{ TABLE }} ADD CONSTRAINT {{ NAME }} CHECK ({{ COLUMN }} {{ OPERATOR }} '{{ CHECK }}');";
                break;
            case ATTRIBUTE_RANGE_RULE:
                value = "ALTER TABLE {{ TABLE }} ADD CONSTRAINT {{ NAME }} CHECK ( {{ COLUMN }} [[ NOT ]] BETWEEN {{ NUMBER_1 }} AND {{ NUMBER_2 }} );";
                break;
            case ATTRIBUTE_COMPARE_RULE:
                value = "ALTER TABLE {{ TABLE }} ADD CONSTRAINT {{ NAME }} CHECK ( {{ COLUMN }} {{ OPERATOR }} {{ VALUE }} );";
                break;
            case UNKNOWN:
                break;
        }

        return new Template("tuple_compare_rule", value, "", DatabaseType.ORACLE);
    }
}
