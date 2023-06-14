package com.mahendra.rest;


import java.util.HashSet;
import java.util.Set;

import com.mahendra.exceptions.ProductExceptionMapper;

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
		resourceSet.add(ProductExceptionMapper.class);
		return resourceSet;
	}

}
