package com.tosad.brg.api.domain.businessRule;

import com.tosad.brg.api.domain.template.TemplateTag;

import javax.persistence.*;

@Entity
@Table(name = "BUSINESSRULE_TAG")
public class BusinessRuleTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(name = "value")
    private String value;

//    private TemplateTag templateTag;

    public BusinessRuleTag(int id, String value, TemplateTag templateTag) {
        this.id = id;
        this.value = value;
//        this.templateTag = templateTag;
    }

    public BusinessRuleTag() {
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

//    public TemplateTag getTemplateTag() {
//        return templateTag;
//    }
}
