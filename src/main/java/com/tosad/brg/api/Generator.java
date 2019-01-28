package com.tosad.brg.api;

import com.tosad.brg.api.api.BusinessRuleJSON;
import com.tosad.brg.api.hibernate.HibernateUtils;
import com.tosad.brg.api.hibernate.domain.businessRule.BusinessRule;
import com.tosad.brg.api.hibernate.domain.businessRule.BusinessRuleTag;
import com.tosad.brg.api.hibernate.domain.template.Template;
import com.tosad.brg.api.hibernate.domain.template.TemplateTag;
import com.tosad.brg.api.persistence.BusinessRulePersistence;
import com.tosad.brg.api.persistence.BusinessRuleTagPersistence;
import com.tosad.brg.api.persistence.TemplatePersistence;
import org.json.simple.JSONArray;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;


@Path("/s")
public class Generator {

    @GET
        @Path("/businessrule")
    @Produces("application/json")
    public String getCreate(@QueryParam("businessrule") int businessRuleId) {
        BusinessRule businessRule = BusinessRulePersistence.getBusinessRuleById(businessRuleId);
        Template template = TemplatePersistence.getTemplateByBusinessRuleType(businessRule.businessRuleType);
        List<BusinessRuleTag> businessRuleTagList = BusinessRuleTagPersistence.getBusinessRuleTagsByBusinessRule(businessRule);
        HashMap<BusinessRuleTag, TemplateTag> businessRuleHashMap = BusinessRuleTagPersistence.getBusinessRuleHashMapByBusinessRuleTags(businessRuleTagList);

        String test = BusinessRuleJSON.generateSQL(template, businessRuleHashMap);

        HibernateUtils.close();

        return test;
    }


}
