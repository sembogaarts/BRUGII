package com.tosad.brm.web;

import com.tosad.brm.web.hibernate.HibernateUtils;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRule;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.util.ArrayList;
import java.util.List;

public class BusinessRulePersistence {
    public static List getAllBusinessRules() throws Exception {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try {
            Query query = sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM BUSINESSRULE;");
            query.setResultTransformer(Transformers.aliasToBean(BusinessRule.class));
            ArrayList<BusinessRule> entries = (ArrayList<BusinessRule>) query.getResultList();
            return entries;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
