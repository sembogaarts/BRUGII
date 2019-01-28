package com.tosad.brg.domain.businessRule;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "BUSINESSRULETYPE")
public class BusinessRuleType {

    @Id
    @SequenceGenerator(name = "BUSINESSRULETYPE_SEQUENCE", sequenceName = "BUSINESSRULETYPE_SEQUENCE", allocationSize = 1)
    public int id;

    @javax.persistence.Column(name = "name")
    public String name;

    public BusinessRuleType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public BusinessRuleType() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    TUPLE_COMPARE_RULE("tuple_compare_rule"),
//    ATTRIBUTE_RANGE_RULE("attribute_range_rule"),
//    ATTRIBUTE_COMPARE_RULE("attribute_compare_rule"),
//    UNKNOWN("unknown");
//
//    @OneToMany(mappedBy = "businessRuleType")
//    Set<Template> template;
//
//    @OneToMany(mappedBy = "businessRuleType")
//    Set<BusinessRule> businessRule;
}