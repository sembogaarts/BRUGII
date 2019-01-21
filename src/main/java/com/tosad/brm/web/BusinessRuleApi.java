package com.tosad.brm.web;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;


public class BusinessRuleApi {

    @GET
    @Path("")
    @Produces("application/json")
    public String getBusinessRules() {
//		JsonArrayBuilder jab = Json.createArrayBuilder();
//		JsonObjectBuilder job = Json.createObjectBuilder();
//
//		jab.add(job);
//
//		JsonArray array = jab.build();
//		return array.toString();
        return "";
    }

    @POST
    @Path("")
    @Produces("application/json")
    public String postBusinessRule() {
        return "";
    }

}
