package com.tosad.brg.domain.template;

import com.tosad.brg.domain.businessRule.BusinessRuleTag;
import com.tosad.brg.domain.type.TemplateTagType;

import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.Column;


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


    public TemplateTag(String key, TemplateTagType templateTagType, Template template) {
        this.key = key;
        this.templateTagType = templateTagType.getType();
        this.template = template;
    }

    public TemplateTag() {

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
}
