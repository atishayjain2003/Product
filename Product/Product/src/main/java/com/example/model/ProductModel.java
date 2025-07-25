//package com.example.model;
//
//import org.springframework.stereotype.Component;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//
//@Entity
//
//public class ProductModel {
//	
//	@Id
//	private int productId;
//	private String productName;
//	private int productPrice;
//	
//	//defining the constructor
//	//defining the no argument constructor required by spring jpa
//	public ProductModel()
//	{
//		
//	}
//	public ProductModel(int productId, String productName, int productPrice)
//	{
//		this.productId=productId;
//		this.productName=productName;
//		this.productPrice=productPrice;
//	}
//	
//	//applying getter and setter functions
//	public int getProductId()
//	{
//		return productId;
//	}
//	public void setProductId(int productId)
//	{
//		this.productId=productId;
//	}
//	
//	public String getProductName()
//	{
//		return productName;
//	}
//	public void setProductName(String productName)
//	{
//		this.productName=productName;
//	}
//	public int getProductPrice()
//	{
//		return productPrice;
//	}
//	public void setProductPrice(int productPrice)
//	{
//		this.productPrice=productPrice;
//	}
//	
//	/* Model has now been defined now we need to create service and endpoint*/
//	
//	
//	
//	
//
//}

package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private int productPrice;

    // Default (no-argument) constructor REQUIRED by JPA
    public ProductModel() {
    }

    // Parameterized constructor
    public ProductModel(int productId, String productName, int productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    // Getter and setter functions
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}
