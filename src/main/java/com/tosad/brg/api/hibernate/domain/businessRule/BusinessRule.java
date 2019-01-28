package com.tosad.brg.api.hibernate.domain.businessRule;

import com.tosad.brg.api.hibernate.taskSpecific.Project;

import javax.persistence.*;

@Entity
@Table(name = "BUSINESSRULE")
public class BusinessRule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "BUSINESSRULE_SEQUENCE", sequenceName = "BUSINESSRULE_SEQUENCE", allocationSize = 1)
    public int id;

    @Column(name = "name")
    public String name;

    @ManyToOne
    @JoinColumn(name = "businessruletype_id", nullable = false)
    public BusinessRuleType businessRuleType;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    public Project project;

    public BusinessRule(String name, BusinessRuleType businessRuleType, Project project) {
        this.name = name;
        this.businessRuleType = businessRuleType;
        this.project = project;
    }

    public BusinessRule() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public BusinessRuleType getBusinessRuleType() {
        return businessRuleType;
    }

    public void setBusinessRuleType(BusinessRuleType businessRuleType) {
        this.businessRuleType = businessRuleType;
    }
}
