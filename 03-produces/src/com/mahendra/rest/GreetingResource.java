package com.mahendra.rest;

import jakarta.ws.rs.*;


@Path("/greet") //// Resulting Endpoint would be /api/greet
public class GreetingResource {

	@GET @Produces("application/xml")
	public String greet4() {
		return "Hello World [XML]";
	}
	
	@GET @Produces("text/plain")
	public String greet() {
		return "Hello World [Plain Text]";
	}
	
	@GET @Produces("text/html")
	public String greet2() {
		return "<h2>Hello World [HTML]</h2>";
	}

	
	@GET @Produces("application/json")
	public String greet3() {
		return "Hello World [JSON]";
	}
}

