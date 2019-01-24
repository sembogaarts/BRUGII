package com.tosad.brm.web.persistence;

import com.tosad.brm.web.hibernate.HibernateUtils;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRule;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRuleType;

import java.util.List;

public class BusinessRulePersistence {
    public static BusinessRule getBusinessRuleById(int businessRuleId) {
        HibernateUtils.getSessionFactory();
        // Create CriteriaQuery
        return HibernateUtils.getSession().get(BusinessRule.class, businessRuleId);
    }
}
