package com.mahendra.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider // Instead of handling an individual request, this component now intercept all the request
// Convert an exception into HTTP Response with Error Code and Message
public class ProductExceptionMapper implements ExceptionMapper<ProductNotFoundException> {

	@Override
	public Response toResponse(ProductNotFoundException ex) {
		return Response.status(404).entity(ex.getMessage()).type("text/plain").build();
	}

}
