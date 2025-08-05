//package com.example.controller;
//
//import java.util.List;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.model.ProductModel;
//import com.example.service.ProductService;
//
//@RestController
//public class ProductController {
//	
//	//this is dependency injection through constructor method
//	private ProductService productService;
//	
//	public ProductController(ProductService productService)
//	{
//		this.productService=productService;
//	}
//	
//	//defining the endpoint
//	
//	@GetMapping("/allproducts")
//	public List<ProductModel> getAllProducts()
//	{
//		return productService.getAllProducts();
//		// retrieving the list through service
//	}
//	
//	@PostMapping("/addproduct")
//	
//	public String addProduct(@RequestBody ProductModel product) {
//	    productService.addProduct(product);
//	    return "The new product is added";// ✅ Correct usage
//	    
//	}
//	
//	@GetMapping("/product/{productId}")
//	public ProductModel getProductById(@PathVariable int productId)
//	{
//		ProductModel returnedproduct= productService.getProductById(productId)
//				return returnedproduct;
//	}
//	
//	@DeleteMapping("/product/{productId}")
//	public void deleteByProductId(@PathVariable int productId)
//	{
//		productService.deleteByProductId(productId);
//	}
//	
//	@PutMapping("/product/updateProduct")
//	public String updateProduct(@RequestBody ProductModel product)
//	{
//		productService.updateProduct(product);
//		return "The update is successful";
//	}
//
//
//}

package com.example.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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

// Optional: Good practice to add a base path for all endpoints in this controller
public class ProductController {

    private final ProductService productService;
    private final MessageSource messageSource;

    // Constructor Injection
    public ProductController(ProductService productService, MessageSource messageSource) {
        this.productService = productService;
        this.messageSource=messageSource;
    }
    
    

    // Endpoint for getting all products
    @GetMapping("/allproducts")
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    // Endpoint for adding a product. Returns the created product.
    // Spring will default to 200 OK and serialize the returned object to JSON.
    @PostMapping("/addproduct")
    public ProductModel addProduct(@RequestBody ProductModel product) {
        ProductModel createdProduct = productService.addProduct(product);
        return createdProduct;
    }

    // Endpoint for getting a product by ID. Returns the product if found.
    // If the product is not found (service returns null), Spring will return 200 OK
    // with a null/empty JSON body. For a proper 404 Not Found, you'd need custom exception handling.
    @GetMapping("/product/{productId}")
    public ProductModel getProductById(@PathVariable int productId) {
        ProductModel product = productService.getProductById(productId);
        return product; // Will be null if not found
    }

    // Endpoint for deleting a product by ID.
    // Spring will default to 200 OK or 204 No Content for void methods.
    @DeleteMapping("/product/{productId}")
    public void deleteByProductId(@PathVariable int productId) {
        productService.deleteByProductId(productId);
    }

    // Endpoint for updating a product. Returns the updated product.
    // If the product is not found for update (service returns null), Spring will return 200 OK
    // with a null/empty JSON body. For a proper 404 Not Found, you'd need custom exception handling.
    @PutMapping("/product/updateProduct")
    public ProductModel updateProduct(@RequestBody ProductModel product) {
        ProductModel updatedProduct = productService.updateProduct(product);
        return updatedProduct; // Will be null if not found for update
    }
    
    @GetMapping("/hello")
    public String helloWorld()
    {
    	Locale locale=LocaleContextHolder.getLocale();
    	return messageSource.getMessage("greeting.message", null, "Default Message", locale);
    }
    
}