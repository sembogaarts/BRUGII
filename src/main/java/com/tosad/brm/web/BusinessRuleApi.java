package com.tosad.brm.web;

import com.palominolabs.jersey.cors.Cors;
import com.palominolabs.jersey.cors.CorsPreflight;
import com.tosad.brm.web.api.BusinessRuleTypeJSON;
import com.tosad.brm.web.api.TemplateJSON;
import com.tosad.brm.web.hibernate.HibernateUtils;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRule;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRuleTag;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRuleType;
import com.tosad.brm.web.hibernate.domain.template.Template;
import com.tosad.brm.web.hibernate.domain.template.TemplateTag;
import com.tosad.brm.web.persistence.BusinessRulePersistence;
import com.tosad.brm.web.persistence.BusinessRuleTagPersistence;
import com.tosad.brm.web.persistence.TemplatePersistence;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import java.util.List;

import static com.tosad.brm.web.api.TemplateTagJSON.generateFromList;
import static com.tosad.brm.web.persistence.BusinessRuleTypePersistence.getAllBusinessRuleTypes;
import static com.tosad.brm.web.persistence.BusinessRuleTypePersistence.getBusinessRuleTypeById;
import static com.tosad.brm.web.persistence.TemplatePersistence.getTemplateByBusinessRuleType;
import static com.tosad.brm.web.persistence.TemplatePersistence.getTemplateTagsByTemplate;

@Path("/businessrule")
public class BusinessRuleApi {

    @GET
    @Path("/data")
    @Produces("application/json")
    @Cors
    public String getCreate(@QueryParam("businessrule") int businessRuleId) {
        BusinessRule businessRule = BusinessRulePersistence.getBusinessRuleById(businessRuleId);
        Template template = TemplatePersistence.getTemplateByBusinessRuleType(businessRule.businessRuleType);
        List<BusinessRuleTag> businessRuleTagList = BusinessRuleTagPersistence.getBusinessRuleTagsByTemplateAndBusinessRule(template, businessRule);

        JSONArray jsonArray = new JSONArray();
        businessRuleTagList.forEach(businessRuleTag->
                jsonArray.add(businessRuleTag.value)
        );

        HibernateUtils.close();

        return jsonArray.toJSONString();
    }

    @GET
    @Path("/types")
    @Produces("application/json")
    @Cors
    @CorsPreflight
    public String get() {
        JSONArray jsonArray = new JSONArray();
        try {
            getAllBusinessRuleTypes()
                    .forEach(businessRuleType ->
                            jsonArray.add(BusinessRuleTypeJSON.generate(businessRuleType))
                    );
        } catch (Exception e) {
            e.printStackTrace();
        }


        HibernateUtils.close();

        return jsonArray.toJSONString();
    }

    @GET
    @Path("/type")
    @Produces("application/json")
    @Cors
    public String getBusinessRuleTemplate(@QueryParam("id") int businessRuleTypeId) {
        JSONObject data = new JSONObject();
        try {
            BusinessRuleType businessRuleType = getBusinessRuleTypeById(businessRuleTypeId);

            Template template = getTemplateByBusinessRuleType(businessRuleType);
            data = TemplateJSON.generate(template);
            List<TemplateTag> templateTags = getTemplateTagsByTemplate(template);

            data.put("tags", generateFromList(templateTags));

            HibernateUtils.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data.toJSONString();
    }

    @PUT
    @Path("/updateBusinessRules")
    @Produces("application/json")
    public void update() {

    }

    @DELETE
    @Path("/deleteBusinessRule")
    @Produces("application/json")
    public void delete() {

    }
}