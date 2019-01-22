package com.tosad.brm.web;

import java.awt.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

public class BusinessRuleApi implements Api {

    @POST
    @Path("/createBusinessRules")
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
    @Path("/getBusinessRulesTypes")
    @Produces("application/json")
    @Override
    public String get() {
    	List alleBusinessRules = new ArrayList();
    	alleBusinessRules.add(getAllBusinessRules());
    	
    	JsonArrayBuilder jab = Json.createArrayBuilder();
    	JsonObjectBuilder job = Json.createObjectBuilder();
    	
		jab.add(job);

		JsonArray array = jab.build();
		return array.toString();
    }
    
    @GET
    @Path("/getBusinessRules/{businnessRuleType}")
    @Produces("application/json")
    public String getBusinessRules(@PathParam("businessRuleType") String businessRuleType) {
		JsonArrayBuilder jab = Json.createArrayBuilder();

		JsonObjectBuilder job = Json.createObjectBuilder();
		
		job.add();
		
		jab.add(job)
		
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
