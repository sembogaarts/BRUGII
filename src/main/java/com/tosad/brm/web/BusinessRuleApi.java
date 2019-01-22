package com.tosad.brm.web;

import javax.ws.rs.*;

@Path("/businessrules")
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
        return "adsa";
    }

    @PUT
    @Path("/update")
    @Produces("application/json")
    @Override
    public void update() {

    }

    @DELETE
    @Path("/delete")
    @Produces("application/json")
    public void delete() {

    }
}
