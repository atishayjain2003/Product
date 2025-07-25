//package com.example.service;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.example.Repository.ProductRepository;
//import com.example.model.ProductModel;
//
//
//
//
//@Service
//public class ProductService {
//	
////	private List<ProductModel> productList=new ArrayList<>();
////	
////	public ProductService()
////	{
////		productList.add(new ProductModel(1, "Lenovo Laptop", 60000));
////		productList.add(new ProductModel(2, "Apple I Phone", 68000));
////		productList.add(new ProductModel(3, "Kent Air Fryer", 12000));
////	}
//	
//	private ProductRepository productRepository;
//	public ProductService(ProductRepository productRepository)
//	{
//		this.productRepository=productRepository;
//	}
//	//Product Model is for what we will eventually return 
//	public List<ProductModel> getAllProducts()
//	{
//		//this is the old manual method
//		//return productList;
//		return productRepository.findAll();
//		//the above is the new hibernate orm method
//	}
//
//	public ProductModel addProduct(ProductModel productModel)
//	{
//		//this is the old manual method
//		//productList.add(product);
//		return productRepository.save(productModel);
//		//the above one is the new method
//	}
//	
//	public ProductModel getProductById(int productId)
//	{
//
//		//this is the old manual method
////        for (ProductModel product : productList) {
////        if (product.getProductId() == productId) {
////            return product;
////        }
//	 return productRepository.findById(productId);
//	 //the above is the new method
//    }
////    return null;
////
////	}
//	
//	public void deleteByProductId(int productId)
//	{
//		
//		//this is the old manual method
////		productList.removeIf(product -> product.getProductId() == productId);	
//		productRepository.deleteById(productId);
//		//the above is the new method
//	}
//	
//	public ProductModel updateProduct(ProductModel productModel)
//	{
//		//this is the old manual method
////		int index=0;
////		for (int i=0; i<productList.size(); i++)
////		{
////			//calling the productconstructor here
////			if(productList.get(i).getProductId()==product.getProductId())
////			{
////				index=i;
////			}
////		}
////		productList.set(index, product);
////		return "The product has been updated successfully";
//		return productRepository.save(productModel);
//		//the above is the new method
//	}
//	
//	
//
//}


package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.model.ProductModel;
import com.example.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository; // Renamed variable for clarity

    // Constructor Injection
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductModel addProduct(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    public ProductModel getProductById(int productId) {
        Optional<ProductModel> productOptional = productRepository.findById(productId);
        // Returns the ProductModel if found, otherwise null.
        // For a more robust API, consider throwing a custom ProductNotFoundException here.
        return productOptional.orElse(null);
    }

    public void deleteByProductId(int productId) {
        productRepository.deleteById(productId);
    }

    public ProductModel updateProduct(ProductModel productModel) {
        Optional<ProductModel> existingProductOptional = productRepository.findById(productModel.getProductId());

        if (existingProductOptional.isPresent()) {
            ProductModel existingProduct = existingProductOptional.get();

            // Update the fields of the existing product
            existingProduct.setProductName(productModel.getProductName());
            existingProduct.setProductPrice(productModel.getProductPrice());
            // Add other fields here if they can be updated

            // Save the updated existing product
            return productRepository.save(existingProduct);
        } else {
            // Product not found for update. Returns null.
            // For a more robust API, consider throwing a custom ProductNotFoundException here.
            return null;
        }
    }
}


