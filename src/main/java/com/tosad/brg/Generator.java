package com.tosad.brg;

import com.tosad.brg.hibernate.HibernateUtils;
import com.tosad.brg.taskSpecific.api.BusinessRuleJSON;
import com.tosad.brg.domain.businessRule.BusinessRule;
import com.tosad.brg.domain.businessRule.BusinessRuleTag;
import com.tosad.brg.domain.template.Template;
import com.tosad.brg.domain.template.TemplateTag;
import com.tosad.brg.taskSpecific.persistence.BusinessRulePersistence;
import com.tosad.brg.taskSpecific.persistence.BusinessRuleTagPersistence;
import com.tosad.brg.taskSpecific.persistence.TemplatePersistence;
import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.HashMap;
import java.util.List;


@Path("/")
public class Generator {

    @GET
    @Path("businessrule")
    @Produces("application/json")
    public String getCreate(@QueryParam("businessrule") int businessRuleId) {
        BusinessRule businessRule = BusinessRulePersistence.getBusinessRuleById(businessRuleId);
        Template template = TemplatePersistence.getTemplateByBusinessRuleType(businessRule.businessRuleType);
        List<BusinessRuleTag> businessRuleTagList = BusinessRuleTagPersistence.getBusinessRuleTagsByBusinessRule(businessRule);
        HashMap<BusinessRuleTag, TemplateTag> businessRuleHashMap = BusinessRuleTagPersistence.getBusinessRuleHashMapByBusinessRuleTags(businessRuleTagList);


        System.out.println(businessRuleHashMap);

        String code = BusinessRuleJSON.generateSQL(template, businessRuleHashMap);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        HibernateUtils.close();

        return jsonObject.toJSONString();
    }

}
