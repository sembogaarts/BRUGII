package com.tosad.brg.taskSpecific.persistence;

import com.tosad.brg.hibernate.HibernateUtils;
import com.tosad.brg.domain.businessRule.BusinessRule;
import com.tosad.brg.domain.businessRule.BusinessRuleTag;
import com.tosad.brg.domain.template.TemplateTag;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;

public class BusinessRuleTagPersistence {

    public static List<BusinessRuleTag> getBusinessRuleTagsByBusinessRule(BusinessRule businessRule) {
        HibernateUtils.getSessionFactory();
        CriteriaBuilder builder = HibernateUtils.getSession().getCriteriaBuilder();

        CriteriaQuery<BusinessRuleTag> query = builder.createQuery(BusinessRuleTag.class);
        Root<BusinessRuleTag> root = query.from(BusinessRuleTag.class);

        query.select(root).where(
                builder.equal(root.get("businessRule"), businessRule.id)
        );
        return HibernateUtils.getSession().createQuery(query).getResultList();

    }

    public static HashMap<BusinessRuleTag, TemplateTag> getBusinessRuleHashMapByBusinessRuleTags(List<BusinessRuleTag> businessRuleTags) {
        HashMap<BusinessRuleTag, TemplateTag> hashMap = new HashMap<>();
        businessRuleTags.forEach(businessRuleTag -> hashMap.put(businessRuleTag, businessRuleTag.templateTag));

        return hashMap;

    }
}
