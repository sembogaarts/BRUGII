package com.tosad.brg.taskSpecific.persistence;

import com.tosad.brg.hibernate.HibernateUtils;
import com.tosad.brg.domain.BusinessRule;

public class BusinessRulePersistence {
    public static BusinessRule getBusinessRuleById(int businessRuleId) {
        HibernateUtils.getSessionFactory();
        // Create CriteriaQuery
        return HibernateUtils.getSession().get(BusinessRule.class, businessRuleId);
    }
}
