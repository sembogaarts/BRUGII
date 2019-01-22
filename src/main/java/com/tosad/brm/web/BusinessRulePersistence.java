package com.tosad.brm.web;

import com.tosad.brm.web.hibernate.HibernateUtils;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRule;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BusinessRulePersistence {
    public static List getAllBusinessRules() throws Exception {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<BusinessRule> criteria = builder.createQuery(BusinessRule.class);
        Root<BusinessRule> variableRoot = criteria.from(BusinessRule.class);
        criteria.select(variableRoot);

        List<BusinessRule> lol = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        HibernateUtils.close();
        return lol;
    }
}
