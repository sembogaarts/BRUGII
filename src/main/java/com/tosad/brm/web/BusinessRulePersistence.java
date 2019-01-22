package com.tosad.brm.web;

import com.tosad.brm.web.hibernate.HibernateUtils;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRule;
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

    static List<TemplateTag> getAllTemplateTagsByTemplate(Template template) throws Exception {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<TemplateTag> criteria = builder.createQuery(TemplateTag.class);
        Root<TemplateTag> variableRoot = criteria.from(TemplateTag.class);
        criteria.select(variableRoot);

        return HibernateUtils.getSession().createQuery(criteria).getResultList();
    }


    static BusinessRuleType getBusinessRuleTypeById(int id) {
        HibernateUtils.getSessionFactory();
        // Create CriteriaQuery
        return HibernateUtils.getSession().get(BusinessRuleType.class, id);
    }

    static Template getTemplateByBusinessRuleType(BusinessRuleType businessRuleType) {
        HibernateUtils.getSessionFactory();
        // Create CriteriaQuery\

        // @TODO FIX
        return HibernateUtils.getSession().get(Template.class, 1);
    }
}
