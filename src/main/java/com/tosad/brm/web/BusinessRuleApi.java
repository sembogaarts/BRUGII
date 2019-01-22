package com.tosad.brm.web;

import com.tosad.brm.web.api.BusinessRuleTypeJSON;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRule;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRuleType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.ws.rs.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.tosad.brm.web.BusinessRulePersistence.getAllBusinessRules;

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
    @Path("/get")
    @Produces("application/json")
    @Override
    public String get() {
        try {
            List<BusinessRuleType> businessRuleTypes = getAllBusinessRules();
            JSONArray jsonArray = new JSONArray();
            businessRuleTypes.forEach(businessRuleType -> jsonArray.add(BusinessRuleTypeJSON.generate(businessRuleType)));

            return jsonArray.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GET
    @Path("/getBusinessRules/{businnessRuleType}")
    @Produces("application/json")
    public String getBusinessRules(@PathParam("id") String businessRuleType) {
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
        return "";
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