package com.mahendra.models;

import java.util.LinkedList;
import java.util.List;

public class ProductDAO {

	private static ProductDAO instance ;
	
	public static ProductDAO getInstance() {
		if(ProductDAO.instance == null) {
			instance = new ProductDAO();
		}
		
		return instance;
	}
	
	private List<Product> productList = new LinkedList<>();
	
	private ProductDAO() {
		productList.add(new Product("Product X",101,230.9));
		productList.add(new Product("Product Y",102,2200.0));
	}
	
	public Product findById(int id) {
		return productList.stream().filter(p -> p.getProductId() == id).findFirst().get();
	}
	
	public void save(Product product) {
		productList.add(product);
	}
}
