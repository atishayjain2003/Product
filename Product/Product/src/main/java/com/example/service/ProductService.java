package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.ProductModel;




@Service
public class ProductService {
	
	private List<ProductModel> productList=new ArrayList<>();
	
	public ProductService()
	{
		productList.add(new ProductModel(1, "Lenovo Laptop", 60000));
		productList.add(new ProductModel(2, "Apple I Phone", 68000));
		productList.add(new ProductModel(3, "Kent Air Fryer", 12000));
	}
	
	public List<ProductModel> getAllProducts()
	{
		return productList;
	}

	public void addProduct(ProductModel product)
	{
		productList.add(product);
	}
	
	public ProductModel getProductById(int productId)
	{

        for (ProductModel product : productList) {
        if (product.getProductId() == productId) {
            return product;
        }
    }
    return null;

	}
	
	public void deleteByProductId(int productId)
	{
		
			
		productList.removeIf(product -> product.getProductId() == productId);
			

		
		
	}
	
	

}
