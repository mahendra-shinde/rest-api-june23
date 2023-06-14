package com.mahendra.exceptions;

public class ProductNotFoundException extends RuntimeException {
	
	public ProductNotFoundException(int productId) {
		super("Product "+ productId + " not found !");
	}
}
