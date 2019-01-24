package com.tosad.brm.web.persistence;

import com.tosad.brm.web.hibernate.HibernateUtils;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRule;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRuleType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
}
