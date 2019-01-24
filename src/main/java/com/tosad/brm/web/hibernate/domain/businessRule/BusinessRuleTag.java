package com.tosad.brm.web.hibernate.domain.businessRule;

import com.tosad.brm.web.hibernate.domain.template.TemplateTag;

import javax.persistence.*;

@Entity
@Table(name = "BUSINESSRULETAG")
public class BusinessRuleTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "BUSINESSRULE_TAG_SEQUENCE", sequenceName = "BUSINESSRULE_TAG_SEQUENCE", allocationSize = 1)
    public int id;

    @Column(name = "value")
    public String value;

    @OneToOne()
    @JoinColumn(name = "templateTag_id")
    public TemplateTag templateTag;

    @ManyToOne
    @JoinColumn(name = "businessRule_id")
    public BusinessRule businessRule;

    public BusinessRuleTag() {
    }

    public BusinessRuleTag(String value, TemplateTag templateTag, BusinessRule businessRule) {
        this.value = value;
        this.templateTag = templateTag;
        this.businessRule = businessRule;
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
