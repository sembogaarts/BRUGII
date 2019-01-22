package com.tosad.brm.web.hibernate.domain.businessRule;

import com.tosad.brm.web.hibernate.taskSpecific.Project;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//    public String generateCode() {
//        String code = template.getScript();
//
//        for (Map.Entry<TemplateTag, BusinessRuleTag> entry : businessRuleTagHashMap.entrySet()) {
//            TemplateTag templateTag = entry.getKey();
//            BusinessRuleTag businessRuleTag = entry.getValue();
//            code = code.replace(templateTag.getTemplateKey(), businessRuleTag.getValue());
//        }
//
//        return code;
//    }

    public BusinessRuleType getBusinessRuleType() {
        return businessRuleType;
    }

    public void setBusinessRuleType(BusinessRuleType businessRuleType) {
        this.businessRuleType = businessRuleType;
    }
}
