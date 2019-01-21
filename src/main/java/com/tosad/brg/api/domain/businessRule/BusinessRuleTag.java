package com.tosad.brg.api.domain.businessRule;

import com.tosad.brg.api.domain.template.TemplateTag;

import javax.persistence.*;

@Entity
@Table(name = "BUSINESSRULETAG")
public class BusinessRuleTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="BUSINESSRULE_TAG_SEQUENCE", sequenceName="BUSINESSRULE_TAG_SEQUENCE", allocationSize=1)
    public int id;

    @Column(name = "value")
    private String value;

//    @OneToOne(mappedBy="businessRuleTag")
//    @JoinColumn(name = "templateTag")
//    private TemplateTag templateTag;

    @ManyToOne
    @JoinColumn(name = "businessRuleTag_id")
    private BusinessRule businessRule;


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
