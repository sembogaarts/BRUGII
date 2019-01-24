package com.tosad.brm.web.persistence;

import com.tosad.brm.web.hibernate.HibernateUtils;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRule;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRuleTag;
import com.tosad.brm.web.hibernate.domain.template.Template;
import com.tosad.brm.web.hibernate.domain.template.TemplateTag;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BusinessRuleTagPersistence {

    public static List<BusinessRuleTag> getBusinessRuleTagsByTemplateAndBusinessRule(Template template, BusinessRule businessRule) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        CriteriaBuilder builder = HibernateUtils.getSession().getCriteriaBuilder();

        CriteriaQuery<BusinessRuleTag> query = builder.createQuery(BusinessRuleTag.class);
        Root<BusinessRuleTag> root = query.from(BusinessRuleTag.class);

        query.select(root).where(builder.and(
                builder.equal(root.get("templateTag"), template.id),
                builder.equal(root.get("businessRule"), businessRule.id))
        );

        return HibernateUtils.getSession().createQuery(query).getResultList();
    }
}
