package com.tosad.brg.domain.businessRule;

import com.tosad.brg.domain.project.Project;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "BUSINESSRULE")
public class BusinessRule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "BUSINESSRULE_SEQUENCE", sequenceName = "BUSINESSRULE_SEQUENCE", allocationSize = 1)
    public int id;

    @javax.persistence.Column(name = "name")
    public String name;

    @ManyToOne
    @JoinColumn(name = "businessruletype_id", nullable = false)
    public BusinessRuleType businessRuleType;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    public Project project;

    @Column(name = "active")
    public boolean active;

    public BusinessRule() {
    }

    public BusinessRule(String name, BusinessRuleType businessRuleType, Project project, boolean active) {
        this.name = name;
        this.businessRuleType = businessRuleType;
        this.project = project;
        this.active = active;
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
