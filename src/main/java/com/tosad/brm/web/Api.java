package com.tosad.brm.web;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;


public class Api {
	
	@GET
	@Path("")
	@Produces("application/json")
	public String getBusinessRules() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		JsonObjectBuilder job = Json.createObjectBuilder();
		
		jab.add(job);
		
		JsonArray array = jab.build();
		return array.toString();
	}
	
	
}
