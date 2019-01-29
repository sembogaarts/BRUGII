package com.tosad.brm.web;

import com.tosad.brm.web.domain.type.TemplateTagType;
import com.tosad.brm.web.hibernate.HibernateUtils;
import com.tosad.brm.web.domain.businessRule.BusinessRule;
import com.tosad.brm.web.domain.businessRule.BusinessRuleTag;
import com.tosad.brm.web.domain.businessRule.BusinessRuleType;
import com.tosad.brm.web.domain.template.Template;
import com.tosad.brm.web.domain.template.TemplateTag;
import com.tosad.brm.web.taskSpecific.api.BusinessRuleJSON;
import com.tosad.brm.web.taskSpecific.api.BusinessRuleTagJSON;
import com.tosad.brm.web.taskSpecific.api.BusinessRuleTypeJSON;
import com.tosad.brm.web.taskSpecific.api.TemplateJSON;
import com.tosad.brm.web.taskSpecific.persistence.BusinessRulePersistence;
import com.tosad.brm.web.taskSpecific.persistence.BusinessRuleTagPersistence;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.*;
import java.util.HashMap;
import java.util.List;

import static com.tosad.brm.web.taskSpecific.api.TemplateTagJSON.generateFromList;
import static com.tosad.brm.web.taskSpecific.persistence.BusinessRulePersistence.saveBusinessRule;
import static com.tosad.brm.web.taskSpecific.persistence.BusinessRuleTagPersistence.saveBusinessRuleTags;
import static com.tosad.brm.web.taskSpecific.persistence.BusinessRuleTypePersistence.getAllBusinessRuleTypes;
import static com.tosad.brm.web.taskSpecific.persistence.BusinessRuleTypePersistence.getBusinessRuleTypeById;
import static com.tosad.brm.web.taskSpecific.persistence.TemplatePersistence.getTemplateByBusinessRuleType;
import static com.tosad.brm.web.taskSpecific.persistence.TemplatePersistence.getTemplateTagsByTemplate;

@Path("/businessrule")
public class BusinessRuleApi {

    @GET
    @Path("/data")
    @Produces("application/json")
    public String getCreate(@QueryParam("businessrule") int businessRuleId) {
        BusinessRule businessRule = BusinessRulePersistence.getBusinessRuleById(businessRuleId);
        List<BusinessRuleTag> businessRuleTagList = BusinessRuleTagPersistence.getBusinessRuleTagsByBusinessRule(businessRule);
        HashMap<BusinessRuleTag, TemplateTag> businessRuleHashMap = BusinessRuleTagPersistence.getBusinessRuleHashMapByBusinessRuleTags(businessRuleTagList);

        Template template = getTemplateByBusinessRuleType(businessRule.businessRuleType);

        JSONObject data = TemplateJSON.generate(template);
        data.put("tags", generateFromList(businessRuleHashMap));

        HibernateUtils.close();
        return data.toJSONString();
    }

    @GET
    @Path("/rules")
    @Produces("application/json")
    public String getAllRules() {
        List<BusinessRule> businessRuleList = BusinessRulePersistence.getAllBusinessRules();

        HibernateUtils.close();

        return BusinessRuleJSON.parseBusinessRules(businessRuleList).toJSONString();
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
        String businessRuleName = businessRule.getBusinessRuleType().getName();

        String businessRulePrefix = businessRule.getBusinessRulePrefix(businessRuleName);

        int sequence = 01;
        saveBusinessRule(businessRule);


        List<BusinessRuleTag> businessRuleRaw = BusinessRuleTagJSON.parseTags((JSONArray) jsonObject.get("raw"), businessRule);
        List<BusinessRuleTag> businessRuleTags = BusinessRuleTagJSON.parseTags((JSONArray) jsonObject.get("tags"), businessRule);

//        businessRuleTags.add();
        String categorie = businessRule.getCategorie(businessRuleTags);

        String table = "";
        businessRuleTags.forEach(businessRuleTag -> {
            if (businessRuleTag.templateTag.getTemplateTagType() == TemplateTagType.TABLE) {
                
            }
        });


        String generatedName = "brg_" + table + "_" + categorie + "_" + businessRulePrefix + "_" + sequence;


        // brg_gebruiker_cns_arng_01

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