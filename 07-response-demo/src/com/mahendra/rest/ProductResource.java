package com.mahendra.rest;

import java.util.NoSuchElementException;

import com.mahendra.models.Product;
import com.mahendra.models.ProductDAO;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/products")
public class ProductResource {

	private ProductDAO dao = ProductDAO.getInstance();

	@GET
	@Produces("application/json")
	//// Endpoint URL >>> /api/products?productid=101
	public Response findByProductId(@QueryParam("productid") int id) {
		try {
			Product p = dao.findById(id);
			return Response.ok(p).build();
			}catch(NoSuchElementException ex) {
				return Response.status(404).entity("Product "+id+" doesn't exist !").type("text/plain").build();
			}
	}

	/*
	 * Endpoint URL >>> /api/products/101
	 */
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response findByProductId2(@PathParam("id") int id) {
		try {
		Product p = dao.findById(id);
		return Response.ok(p).build();
		}catch(NoSuchElementException ex) {
			return Response.status(404).entity("Product "+id+" doesn't exist !").type("text/plain").build();
		}
			
		}

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String create(Product product) {
		System.out.println("Creating new product ..." + product.getProductName());
		dao.save(product);
		return "success";
	}

	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("text/plain")
	public String update(@PathParam("id") int id, Product product) {
		Product oldProduct = dao.findById(id);
		dao.update(product, oldProduct);
		return "success";
	}
	
	@PATCH
	// /api/products/101/price/199.00
	@Path("/{id}/update-price/{newprice}")
	@Produces("application/json")
	public Product setPrice(@PathParam("id")int id, @PathParam("newprice") double newprice) {
		Product product = dao.findById(id);
		product.setPrice(newprice);
		return product;
	}
	
	
	@DELETE @Path("/{id}") @Produces("text/plain")
	public String removeById(@PathParam("id") int id) {
		dao.remove(id);
		return "Deleted";
	}
}
