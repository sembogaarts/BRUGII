package com.tosad.brg.api.hibernate.domain.template;

import com.tosad.brg.api.hibernate.domain.businessRule.BusinessRuleTag;
import com.tosad.brg.api.hibernate.domain.type.TemplateTagType;

import javax.persistence.*;


@Entity
@Table(name = "TEMPLATETAG")
public class TemplateTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "TEMPLATETAG_SEQUENCE", sequenceName = "TEMPLATETAG_SEQUENCE", allocationSize = 1)
    public int id;

    @ManyToOne
    @JoinColumn(name = "template_id", nullable = false)
    private Template template;

    @Column(name = "key")
    public String key;

    @Column(name = "template_tag_type")
    public TemplateTagType templateTagType;


    public TemplateTag(String key, TemplateTagType templateTagType, Template template) {
        this.key = key;
        this.templateTagType = templateTagType;
        this.template = template;
//        this.templateTagType = TemplateTagType.getTypeByText(templateTagTypeStr);
    }

    public String getTemplateKey() {
        return String.format("{{ %s }}", key);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

//    public TemplateTagType getTemplateTagType() {
//        return templateTagType;
//    }
//
//    public void setTemplateTagType(TemplateTagType templateTagType) {
//        this.templateTagType = templateTagType;
//    }
}
