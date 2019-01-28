package com.tosad.brg.api.persistence;

import com.tosad.brg.api.hibernate.HibernateUtils;
import com.tosad.brg.api.hibernate.domain.businessRule.BusinessRule;
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
}
