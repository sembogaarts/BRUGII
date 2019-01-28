package com.tosad.brm.web;

import com.tosad.brm.web.api.BusinessRuleJSON;
import com.tosad.brm.web.api.BusinessRuleTagJSON;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.*;
import java.util.HashMap;
import java.util.List;

import static com.tosad.brm.web.api.TemplateTagJSON.generateFromList;
import static com.tosad.brm.web.persistence.BusinessRulePersistence.saveBusinessRule;
import static com.tosad.brm.web.persistence.BusinessRuleTagPersistence.saveBusinessRuleTags;
import static com.tosad.brm.web.persistence.BusinessRuleTypePersistence.getAllBusinessRuleTypes;
import static com.tosad.brm.web.persistence.BusinessRuleTypePersistence.getBusinessRuleTypeById;
import static com.tosad.brm.web.persistence.TemplatePersistence.getTemplateByBusinessRuleType;
import static com.tosad.brm.web.persistence.TemplatePersistence.getTemplateTagsByTemplate;

@Path("/businessrule")
public class BusinessRuleApi {

    @GET
    @Path("/data")
    @Produces("application/json")
    public String getCreate(@QueryParam("businessrule") int businessRuleId) {
        BusinessRule businessRule = BusinessRulePersistence.getBusinessRuleById(businessRuleId);
        List<BusinessRuleTag> businessRuleTagList = BusinessRuleTagPersistence.getBusinessRuleTagsByBusinessRule(businessRule);
        HashMap<BusinessRuleTag, TemplateTag> businessRuleHashMap = BusinessRuleTagPersistence.getBusinessRuleHashMapByBusinessRuleTags(businessRuleTagList);

        JSONArray jsonArray = generateFromList(businessRuleHashMap);

        HibernateUtils.close();

        return jsonArray.toJSONString();
    }

    @GET
    @Path("/types")
    @Produces("application/json")
    public String get() {
        JSONArray jsonArray = new JSONArray();
        try {
            getAllBusinessRuleTypes().forEach(businessRuleType ->
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

    @POST
    @Path("/create")
    @Produces("application/json")
    public String createBusinessRule(String data) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(data);
        BusinessRule businessRule = BusinessRuleJSON.parseBusinessRule(jsonObject);
        saveBusinessRule(businessRule);

        List<BusinessRuleTag> businessRuleTags = BusinessRuleTagJSON.parseTags((JSONArray) jsonObject.get("tags"), businessRule);
        saveBusinessRuleTags(businessRuleTags);

        HibernateUtils.close();

        return jsonObject.toJSONString();
    }

    @DELETE
    @Path("/deleteBusinessRule")
    @Produces("application/json")
    public void delete() {

    }
}