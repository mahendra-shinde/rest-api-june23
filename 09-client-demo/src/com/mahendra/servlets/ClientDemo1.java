package com.mahendra.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.mahendra.models.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;

/**
 * Servlet implementation class ClientDemo1
 */
@WebServlet("/demo1")
public class ClientDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ClientDemo1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		//Initialize a new REST Client using JAX-RS API
		Client client = ClientBuilder.newClient();
		String result = client.target("https://dummy.restapiexample.com/api/v1/employee/1")
							.request("application/json")
							.get(String.class);
		out.println("Result \n\r" + result);
		Product[] products = client.target("http://localhost:8080/02-pojo-json/api/products")
				.request().accept("application/json").get(Product[].class);
		
		out.println("Found "+ products.length);
		for(Product p : products) {
			out.println(p.getProductName()+" "+p.getPrice());
		}
		
		out.close();
	}

}
