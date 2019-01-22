package com.tosad.brm.web;

import com.tosad.brm.web.api.BusinessRuleTypeJSON;
import com.tosad.brm.web.api.TemplateJSON;
import com.tosad.brm.web.hibernate.HibernateUtils;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRuleType;
import com.tosad.brm.web.hibernate.domain.template.Template;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import java.util.List;

import static com.tosad.brm.web.BusinessRulePersistence.*;

@Path("/businessrule")
public class BusinessRuleApi implements Api {

    @POST
    @Path("/create")
    @Produces("application/json")
    @Override
    public void create() {
//		JsonArrayBuilder jab = Json.createArrayBuilder();
//		JsonObjectBuilder job = Json.createObjectBuilder();
//
//		jab.add(job);
//
//		JsonArray array = jab.build();
//		return array.toString();
    }

    @GET
    @Path("/types")
    @Produces("application/json")
    @Override
    public String get() {
        String respone = "";
        try {
            List<BusinessRuleType> businessRuleTypes = getAllBusinessRuleTypes();
            JSONArray jsonArray = new JSONArray();
            businessRuleTypes.forEach(businessRuleType -> jsonArray.add(BusinessRuleTypeJSON.generate(businessRuleType)));
            respone = jsonArray.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
        }


        HibernateUtils.close();

        return respone;
    }

    @GET
    @Path("/type")
    @Produces("application/json")
    public String getBusinessRuleTemplate(@PathParam("id") int businessRuleTypeId) {
        System.out.println();
        BusinessRuleType businessRuleType = getBusinessRuleTypeById(businessRuleTypeId);
        Template template = getTemplateByBusinessRuleType(businessRuleType);
        HibernateUtils.close();
        return TemplateJSON.generate(template).toJSONString();
//        List<String> alleBusinessRules = null;
//        JsonArrayBuilder jab = Json.createArrayBuilder();
//
//
//
//        JsonObjectBuilder job = Json.createObjectBuilder();
//        job.add("businessrule");
//
//        jab.add(job);
//
//        JsonArray array = jab.build();
//        return array.toString();
    }

    @PUT
    @Path("/updateBusinessRules")
    @Produces("application/json")
    @Override
    public void update() {

    }

    @DELETE
    @Path("/deleteBusinessRule")
    @Produces("application/json")
    public void delete() {

    }
}