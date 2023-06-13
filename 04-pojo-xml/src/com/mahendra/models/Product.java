package com.mahendra.models;

import jakarta.xml.bind.annotation.XmlRootElement;

// POJO : Plain Old Java Object
@XmlRootElement
public class Product implements java.io.Serializable{

	private String productName;
	private Integer productId;
	private Double price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Product(String productName, Integer productId, Double price) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.price = price;
	}



	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
