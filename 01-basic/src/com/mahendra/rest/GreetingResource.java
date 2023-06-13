package com.mahendra.rest;

import jakarta.ws.rs.*;


@Path("/greet") //// Resulting Endpoint would be /api/greet
public class GreetingResource {

	@GET
	public String greet() {
		return "Hello World [GET]";
	}
	
	@POST
	public String greet2() {
		return "Hello World [POST]";
	}
	
	@PUT
	public String greet3() {
		return "Hello World [PUT]";
	}
	
	@DELETE
	public String greet4() {
		return "Hello World [DELETE]";
	}
}

