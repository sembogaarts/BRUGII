package com.tosad.brm.web;

import com.tosad.brm.web.hibernate.HibernateUtils;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRuleType;
import com.tosad.brm.web.hibernate.domain.template.Template;
import com.tosad.brm.web.hibernate.domain.template.TemplateTag;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

class BusinessRulePersistence {
    static List<BusinessRuleType> getAllBusinessRuleTypes() throws Exception {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<BusinessRuleType> criteria = builder.createQuery(BusinessRuleType.class);
        Root<BusinessRuleType> variableRoot = criteria.from(BusinessRuleType.class);
        criteria.select(variableRoot);

        return HibernateUtils.getSession().createQuery(criteria).getResultList();
    }


    static BusinessRuleType getBusinessRuleTypeById(int id) {
        HibernateUtils.getSessionFactory();
        // Create CriteriaQuery
        return HibernateUtils.getSession().get(BusinessRuleType.class, id);
    }

    static Template getTemplateByBusinessRuleType(BusinessRuleType businessRuleType) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        CriteriaBuilder builder = HibernateUtils.getSession().getCriteriaBuilder();

        CriteriaQuery<Template> query = builder.createQuery(Template.class);
        Root<Template> root = query.from(Template.class);

        query.select(root).where(builder.equal(root.get("businessRuleType"), businessRuleType.id));


        return HibernateUtils.getSession().createQuery(query).getSingleResult();
    }

    static List<TemplateTag> getTemplateTagsByTemplate(Template template) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        CriteriaBuilder builder = HibernateUtils.getSession().getCriteriaBuilder();

        CriteriaQuery<TemplateTag> query = builder.createQuery(TemplateTag.class);
        Root<TemplateTag> root = query.from(TemplateTag.class);

        query.select(root).where(builder.equal(root.get("template"), template.id));


        return HibernateUtils.getSession().createQuery(query).getResultList();
    }
}
