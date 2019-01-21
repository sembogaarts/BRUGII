package com.tosad.brg.api.domain.businessRule;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

import com.tosad.brg.api.domain.template.Template;

@Entity
@Table(name = "BUSINESSRULETYPE")
public class BusinessRuleType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "BUSINESSRULETYPE_SEQUENCE", sequenceName = "BUSINESSRULETYPE_SEQUENCE", allocationSize = 1)
    public int id;

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