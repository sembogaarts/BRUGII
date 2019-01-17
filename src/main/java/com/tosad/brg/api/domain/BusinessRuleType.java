package com.tosad.brg.api.domain;

import com.tosad.brg.api.domain.database.DatabaseConnection;
import com.tosad.brg.api.domain.database.OracleDatabaseConnection;

import java.io.Serializable;

public enum BusinessRuleType implements Serializable {
    TUPLE_COMPARE_RULE("tuple_compare_rule"),
    ATTRIBUTE_RANGE_RULE("attribute_range_rule"),
    ATTRIBUTE_COMPARE_RULE("attribute_compare_rule"),
    UNKNOWN("unkown");

    private String type;

    BusinessRuleType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}