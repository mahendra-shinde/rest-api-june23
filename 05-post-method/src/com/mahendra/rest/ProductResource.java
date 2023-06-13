package com.mahendra.rest;

import com.mahendra.models.Product;
import com.mahendra.models.ProductDAO;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("/products")
public class ProductResource {

	private ProductDAO dao = ProductDAO.getInstance();

	@GET
	@Produces("application/json")
	//// Endpoint URL >>> /api/products?productid=101
	public Product findByProductId(@QueryParam("productid") int id) {
		return dao.findById(id);
	}

	/*
	 * Endpoint URL >>> /api/products/101
	 */
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Product findByProductId2(@PathParam("id") int id) {
		return dao.findById(id);
	}

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String create(Product product) {
		System.out.println("Creating new product ..." + product.getProductName());
		dao.save(product);
		return "success";
	}

}
