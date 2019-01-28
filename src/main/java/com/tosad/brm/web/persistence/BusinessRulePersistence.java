package com.tosad.brm.web.persistence;

import com.tosad.brm.web.hibernate.HibernateUtils;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRule;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRuleType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BusinessRulePersistence {
    public static BusinessRule getBusinessRuleById(int businessRuleId) {
        HibernateUtils.getSessionFactory();
        // Create CriteriaQuery
        return HibernateUtils.getSession().get(BusinessRule.class, businessRuleId);
    }

    public static void saveBusinessRule(BusinessRule businessRule) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();

        session.save(businessRule);
        t.commit();
    }

    public static List<BusinessRule> getAllBusinessRules() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<BusinessRule> criteria = builder.createQuery(BusinessRule.class);
        Root<BusinessRule> variableRoot = criteria.from(BusinessRule.class);
        criteria.select(variableRoot);

        return HibernateUtils.getSession().createQuery(criteria).getResultList();
    }
}
