package com.tosad.brm.web.taskSpecific.persistence;

import com.tosad.brm.web.hibernate.HibernateUtils;
import com.tosad.brm.web.domain.businessRule.BusinessRuleType;
import com.tosad.brm.web.domain.template.Template;
import com.tosad.brm.web.domain.template.TemplateTag;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TemplatePersistence {
    public static Template getTemplateByBusinessRuleType(BusinessRuleType businessRuleType) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        CriteriaBuilder builder = HibernateUtils.getSession().getCriteriaBuilder();

        CriteriaQuery<Template> query = builder.createQuery(Template.class);
        Root<Template> root = query.from(Template.class);

        query.select(root).where(builder.equal(root.get("businessRuleType"), businessRuleType.id));


        return HibernateUtils.getSession().createQuery(query).getSingleResult();
    }

    public static List<TemplateTag> getTemplateTagsByTemplate(Template template) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        CriteriaBuilder builder = HibernateUtils.getSession().getCriteriaBuilder();

        CriteriaQuery<TemplateTag> query = builder.createQuery(TemplateTag.class);
        Root<TemplateTag> root = query.from(TemplateTag.class);

        query.select(root).where(builder.equal(root.get("template"), template.id));


        return HibernateUtils.getSession().createQuery(query).getResultList();
    }
}
