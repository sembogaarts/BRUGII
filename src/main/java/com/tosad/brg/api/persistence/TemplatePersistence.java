package com.tosad.brg.api.persistence;

import com.tosad.brg.api.hibernate.HibernateUtils;
import com.tosad.brg.api.hibernate.domain.businessRule.BusinessRuleType;
import com.tosad.brg.api.hibernate.domain.template.Template;
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
}
