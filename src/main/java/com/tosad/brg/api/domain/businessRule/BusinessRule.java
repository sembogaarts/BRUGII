package com.tosad.brg.api.domain.businessRule;

import com.tosad.brg.api.domain.template.Template;
import com.tosad.brg.api.domain.template.TemplateTag;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "BUSINESSRULE")
public class BusinessRule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "BUSINESSRULE_SEQUENCE", sequenceName = "BUSINESSRULE_SEQUENCE", allocationSize = 1)
    public int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "businessruletype_id", nullable = false)
    private BusinessRuleType businessRuleType;

    @OneToMany(mappedBy = "businessRule")
    Set<BusinessRuleTag> businessRuleTag;


//    HashMap<TemplateTag, BusinessRuleTag> businessRuleTagHashMap;


    public BusinessRule(String name, BusinessRuleType businessRuleType, Template template, HashMap<TemplateTag, BusinessRuleTag> businessRuleTagHashMap) {
        this.name = name;
        this.businessRuleType = businessRuleType;
//        this.businessRuleTagHashMap = businessRuleTagHashMap;
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
}
