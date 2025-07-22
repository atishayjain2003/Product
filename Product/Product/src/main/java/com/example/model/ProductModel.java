package com.example.model;

public class ProductModel {
	
	private int productId;
	private String productName;
	private int productPrice;
	
	//defining the constructor
	public ProductModel(int productId, String productName, int productPrice)
	{
		this.productId=productId;
		this.productName=productName;
		this.productPrice=productPrice;
	}
	
	//applying getter and setter functions
	public int getProductId()
	{
		return productId;
	}
	public void setProductId(int productId)
	{
		this.productId=productId;
	}
	
	public String getProductName()
	{
		return productName;
	}
	public void setProductName(String productName)
	{
		this.productName=productName;
	}
	public int getProductPrice()
	{
		return productPrice;
	}
	public void setProductPrice(int productPrice)
	{
		this.productPrice=productPrice;
	}
	
	/* Model has now been defined now we need to create service and endpoint*/
	
	
	
	

}
