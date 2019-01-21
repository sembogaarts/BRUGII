package com.tosad.brg.api.domain.template;

import com.tosad.brg.api.domain.businessRule.BusinessRuleTag;
import com.tosad.brg.api.domain.type.TemplateTagType;

import javax.persistence.*;


@Entity
@Table(name = "TEMPLATETAG")
public class TemplateTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "TEMPLATETAG_SEQUENCE", sequenceName = "TEMPLATETAG_SEQUENCE", allocationSize = 1)
    public int id;

//    @OneToOne(mappedBy="templateTag")
//    @JoinColumn(name = "businessRuleTag")
//    private BusinessRuleTag businessRuleTag;

    @ManyToOne
    @JoinColumn(name = "template_id", nullable = false)
    private Template template;

    @Column(name = "key")
    public String key;

    @Column(name = "template_tag_type")
    public String templateTagTypeStr;

    private TemplateTagType templateTagType;

    public TemplateTag(String key, String templateTagTypeStr) {
        this.key = key;
        this.templateTagTypeStr = templateTagTypeStr;
        this.templateTagType = TemplateTagType.getTypeByText(templateTagTypeStr);
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
        return templateTagType;
    }

    public void setTemplateTagType(TemplateTagType templateTagType) {
        this.templateTagType = templateTagType;
    }
}
