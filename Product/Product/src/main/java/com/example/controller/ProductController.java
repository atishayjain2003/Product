package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ProductModel;
import com.example.service.ProductService;

@RestController
public class ProductController {
	
	//this is dependency injection through constructor method
	private ProductService productService;
	
	public ProductController(ProductService productService)
	{
		this.productService=productService;
	}
	
	//defining the endpoint
	
	@GetMapping("/allproducts")
	public List<ProductModel> getAllProducts()
	{
		return productService.getAllProducts();
		// retrieving the list through service
	}
	
	@PostMapping("/addproduct")
	
	public String addProduct(@RequestBody ProductModel product) {
	    productService.addProduct(product); // ✅ Correct usage
	    return "The product has been successfully entered";
	}
	
	@GetMapping("/product/{productId}")
	public ProductModel getProductById(@PathVariable int productId)
	{
		return productService.getProductById(productId);
	}
	
	@DeleteMapping("/product/{productId}")
	public void deleteByProductId(@PathVariable int productId)
	{
		productService.deleteByProductId(productId);
	}
	
	@PutMapping("/product/updateProduct")
	public String updateProduct(@RequestBody ProductModel product)
	{
		productService.updateProduct(product);
		return "The update is successful";
	}


}
