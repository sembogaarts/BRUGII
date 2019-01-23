package com.tosad.brm.web.hibernate.domain.template;

import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRuleTag;
import com.tosad.brm.web.hibernate.domain.type.TemplateTagType;

import javax.persistence.*;


@Entity
@Table(name = "TEMPLATETAG")
public class TemplateTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "TEMPLATETAG_SEQUENCE", sequenceName = "TEMPLATETAG_SEQUENCE", allocationSize = 1)
    public int id;

    @OneToOne()
    @JoinColumn(name = "businessRuleTag_id")
    public BusinessRuleTag businessRuleTag;

    @ManyToOne
    @JoinColumn(name = "template_id", nullable = false)
    public Template template;

    @Column(name = "key")
    public String key;

    @Column(name = "template_tag_type")
    public String templateTagType;

    public TemplateTag() {

    }

    public TemplateTag(String key, TemplateTagType templateTagType, Template template) {
        this.key = key;
        this.templateTagType = templateTagType.getType();
        this.template = template;
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

    public TemplateTagType getTemplateTagType() {
        return TemplateTagType.getTypeByText(templateTagType);
    }
}
