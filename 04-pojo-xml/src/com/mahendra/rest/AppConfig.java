package com.mahendra.rest;


import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

// Common prefix for all the resources
@ApplicationPath("/api")
public class AppConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resourceSet = new HashSet<>();
		// Add your REST Resource classes ...
		// JAX-RS would register the resource
		resourceSet.add(ProductResource.class);
		return resourceSet;
	}

}
