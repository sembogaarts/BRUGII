package com.tosad.brm.web.taskSpecific.persistence;

import com.tosad.brm.web.hibernate.HibernateUtils;
import com.tosad.brm.web.domain.businessRule.BusinessRule;
import com.tosad.brm.web.domain.businessRule.BusinessRuleTag;
import com.tosad.brm.web.domain.template.TemplateTag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;

public class BusinessRuleTagPersistence {

//    public static List<BusinessRuleTag> getBusinessRuleTagsByTemplateAndBusinessRule(Template template, BusinessRule businessRule) {
//        HibernateUtils.getSessionFactory();
//        CriteriaBuilder builder = HibernateUtils.getSession().getCriteriaBuilder();
//
//        CriteriaQuery<BusinessRuleTag> query = builder.createQuery(BusinessRuleTag.class);
//        Root<BusinessRuleTag> root = query.from(BusinessRuleTag.class);
//
//        query.select(root).where(builder.and(
//                builder.equal(root.get("templateTag"), template.id),
//                builder.equal(root.get("businessRule"), businessRule.id))
//        );
//
//        return HibernateUtils.getSession().createQuery(query).getResultList();
//    }

    public static void saveBusinessRuleTags(List<BusinessRuleTag> businessRuleTags) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();

        businessRuleTags.forEach(businessRuleTag -> {
            session.save(businessRuleTag);
        });
        t.commit();
    }

    public static List<BusinessRuleTag> getBusinessRuleTagsByBusinessRule(BusinessRule businessRule) {
        HibernateUtils.getSessionFactory();
        CriteriaBuilder builder = HibernateUtils.getSession().getCriteriaBuilder();

        CriteriaQuery<BusinessRuleTag> query = builder.createQuery(BusinessRuleTag.class);
        Root<BusinessRuleTag> root = query.from(BusinessRuleTag.class);

        query.select(root).where(
                builder.equal(root.get("businessRule"), businessRule.id)
        ).orderBy(builder.asc(root.get("id")));
        return HibernateUtils.getSession().createQuery(query).getResultList();

    }

    public static HashMap<BusinessRuleTag, TemplateTag> getBusinessRuleHashMapByBusinessRuleTags(List<BusinessRuleTag> businessRuleTags) {
        HashMap<BusinessRuleTag, TemplateTag> hashMap = new HashMap<>();
        businessRuleTags.forEach(businessRuleTag -> hashMap.put(businessRuleTag, businessRuleTag.templateTag));

        return hashMap;

    }

    public static void removeBusinessRuleTagsByBusinessRule(BusinessRule businessRule) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();
        List<BusinessRuleTag> businessRuleTags = getBusinessRuleTagsByBusinessRule(businessRule);

        businessRuleTags.forEach(businessRuleTag -> {
            session.delete(businessRuleTag);
        });
        t.commit();
    }
}
