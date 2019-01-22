package com.tosad.brm.web;

import com.tosad.brm.web.hibernate.HibernateUtils;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRule;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRuleType;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

class BusinessRulePersistence {
    static List getAllBusinessRules() throws Exception {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<BusinessRuleType> criteria = builder.createQuery(BusinessRuleType.class);
        Root<BusinessRuleType> variableRoot = criteria.from(BusinessRuleType.class);
        criteria.select(variableRoot);

        List<BusinessRuleType> lol = HibernateUtils.getSession().createQuery(criteria).getResultList();
        return lol;
    }
}
