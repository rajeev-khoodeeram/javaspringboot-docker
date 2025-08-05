package com.cloudace.springboot.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudace.springboot.model.Product;

@RestController
public class ProductController {

    // This class will handle product-related requests
    // For example, methods to create, read, update, and delete products

    // Example method to get a product by ID
    public String getProductById(Long id) {
        // Logic to retrieve product by ID
        return "Product details for ID: " + id;
    }

    // Additional methods can be added here as needed
    // For example, to list all products, add a new product, etc.
    // Placeholder for product list
    @GetMapping("/products")
    public List<Product> getAllProducts() { 
        // Logic to retrieve all products
        // For now, returning a sample list
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Sample Product", "This is a sample product description", 19.99));
        products.add(new Product(2L, "Another Product", "This is another product description", 29.99));
    
        return  products; // Returning an empty list for now
     }
    // public Product addProduct(Product product) { ... }
    // public void updateProduct(Long id, Product product) { ... }
    // public void deleteProduct(Long id) { ... }
}
