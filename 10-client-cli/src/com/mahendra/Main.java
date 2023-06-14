package com.mahendra;

import com.mahendra.models.Product;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;

public class Main {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
//		String result = client.target("https://dummy.restapiexample.com/api/v1/employee/1")
//							.request("application/json")
//							.get(String.class);
//		System.out.println("Result \n\r" + result);
//		
		Response response = client.target("http://localhost:8080/02-pojo-json/api/products")
								.request().accept("application/json").buildGet().invoke();
		
		System.out.println(response.getStatus());
		
	}

}
