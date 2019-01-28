package com.tosad.brg.domain;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "BUSINESSRULETAG")
public class BusinessRuleTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "BUSINESSRULE_TAG_SEQUENCE", sequenceName = "BUSINESSRULE_TAG_SEQUENCE", allocationSize = 1)
    public int id;

    @javax.persistence.Column(name = "value")
    public String value;

    @OneToOne()
    @JoinColumn(name = "templateTag_id")
    public TemplateTag templateTag;

    @ManyToOne
    @JoinColumn(name = "businessRule_id")
    public BusinessRule businessRule;

    public BusinessRuleTag() {

    }

    public BusinessRuleTag(int id, String value, TemplateTag templateTag, BusinessRule businessRule) {
        this.id = id;
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

}
