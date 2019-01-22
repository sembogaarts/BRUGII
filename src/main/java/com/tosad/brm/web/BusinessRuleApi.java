package com.tosad.brm.web;

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
        List<String> alleBusinessRules = null;
        try {
            alleBusinessRules = getAllBusinessRules();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String citiesCommaSeparated = alleBusinessRules.stream()
                .collect(Collectors.joining(","));

        return citiesCommaSeparated;
//        JsonArrayBuilder jab = Json.createArrayBuilder();
//        JsonObjectBuilder job = Json.createObjectBuilder();
//        job.add("businessrule", citiesCommaSeparated);
//        jab.add(job);
//        JsonArray array = jab.build();
//        return array.toString();
    }

    @GET
    @Path("/getBusinessRules/{businnessRuleType}")
    @Produces("application/json")
    public String getBusinessRules(@PathParam("id") String businessRuleType) {
        List<String> alleBusinessRules = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();



        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("businessrule");

        jab.add(job);

        JsonArray array = jab.build();
        return array.toString();
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
