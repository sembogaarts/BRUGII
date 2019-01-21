package com.tosad.brg.api.domain.businessRule;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import com.tosad.brg.api.domain.template.Template;


public enum BusinessRuleType implements Serializable {
    TUPLE_COMPARE_RULE("tuple_compare_rule"),
    ATTRIBUTE_RANGE_RULE("attribute_range_rule"),
    ATTRIBUTE_COMPARE_RULE("attribute_compare_rule"),
    UNKNOWN("unknown");

    private String type;

    BusinessRuleType(String type) {
        this.type = type;
    }

    @OneToMany(mappedBy="businessruletype")
    Set<Template> template;


    @Override
    public String toString() {
        return type;
    }
}