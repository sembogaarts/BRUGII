package com.tosad.brm.web.domain.businessRule;

import com.tosad.brm.web.domain.project.Project;

import javax.persistence.*;
import java.util.List;

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


    public String getBusinessRulePrefix(String businessRuleName) {
        String businessRulePrefix = "";

        if(businessRuleName.contains("Attribute Range")) {
            businessRulePrefix = "arng";
        } else if (businessRuleName.contains("Attribute Compare")) {
            businessRulePrefix = "acmp";
        } else if (businessRuleName.contains("Tuple Compare")) {
            businessRulePrefix = "tcmp";
        } else if (businessRuleName.contains("Inter Entity")) {
            businessRulePrefix = "icmp";
        } else if (businessRuleName.contains("Attribute List")) {
            businessRulePrefix = "alis";
        } else if (businessRuleName.contains("Entity Other")) {
            businessRulePrefix = "eoth";
        } else if (businessRuleName.contains("Attribute Other")) {
            businessRulePrefix = "aoth";
        } else if (businessRuleName.contains("Tuple Other")) {
            businessRulePrefix = "toth";
        }
        return businessRulePrefix;
    }

    public String getCategorie(List<BusinessRuleTag> businessRuleRaw){
        Boolean trigger = businessRuleRaw.contains("TRIGGER");
        String type;
        if(trigger) {
            type = "trg";
        } else {
            type = "cns";
        }
        return type;
    }

}
