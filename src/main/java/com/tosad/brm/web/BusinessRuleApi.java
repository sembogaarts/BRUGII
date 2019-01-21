package com.tosad.brm.web;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;


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
        return "";
    }

    @POST
    @Path("/update")
    @Produces("application/json")
    @Override
    public void update() {

    }
}
