package com.tosad.brg.api.domain.businessRule;

import com.tosad.brg.api.domain.template.TemplateTag;

import javax.persistence.*;

@Entity
@Table(name = "BUSINESSRULETAG")
public class BusinessRuleTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "BUSINESSRULE_TAG_SEQUENCE", sequenceName = "BUSINESSRULE_TAG_SEQUENCE", allocationSize = 1)
    public int id;

    @Column(name = "value")
    private String value;

    @OneToOne()
    @JoinColumn(name = "templateTag_id")
    private TemplateTag templateTag;

    @ManyToOne
    @JoinColumn(name = "businessRule_id")
    private BusinessRule businessRule;


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

//    public TemplateTag getTemplateTag() {
//        return templateTag;
//    }
}
