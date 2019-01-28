package com.tosad.brg;

import com.tosad.brg.hibernate.HibernateUtils;
import com.tosad.brg.taskSpecific.api.BusinessRuleJSON;
import com.tosad.brg.domain.BusinessRule;
import com.tosad.brg.domain.BusinessRuleTag;
import com.tosad.brg.domain.Template;
import com.tosad.brg.domain.TemplateTag;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
