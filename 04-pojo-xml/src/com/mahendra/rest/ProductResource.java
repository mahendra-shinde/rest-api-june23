package com.mahendra.rest;

import java.util.LinkedList;
import java.util.List;

import com.mahendra.models.Product;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/products")
public class ProductResource {

	@GET @Produces("application/xml")
	public List<Product> allProducts(){
		List<Product> products = new LinkedList<>();
		products.add(new Product("Product X",101,230.9));
		products.add(new Product("Product Y",1200,230.0));
		
		return products;
	}
}
