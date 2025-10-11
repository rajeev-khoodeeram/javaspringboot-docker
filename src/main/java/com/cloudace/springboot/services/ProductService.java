package com.cloudace.springboot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.cloudace.springboot.model.Product;

public class ProductService {

    // This class will handle business logic related to products
    // For example, methods to create, read, update, and delete products

    // Placeholder for product list
    // In a real application, this would interact with a database or other data
    // source

    // Example method to get a product by ID
    public Product getProductById(int id) {
        // Logic to retrieve a product by its ID
        // For now, returning a dummy product
        Product product = new Product();
        product.setName("Product " + id);
        product.setDescription("Description of Product " + id);
        product.setPrice(34.50);
        return product;
    }

    // Example method to get all products
    public List<Product> getAllProducts() {
        // Logic to retrieve all products
        // For now, returning a sample list
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Laptop", "This is a sample product description", 19.99));
        products.add(new Product(2L, "Mouse", "This is another product description", 29.99));
        return products; // Returning a sample list for now
    }

    public Product addProduct(Product newProduct) {
        // TODO Auto-generated method stub

        return newProduct; // Returning the product as is for now
    }

    @GetMapping("/products/{id}")
    public Product deleteProduct(String string) {

        return null;
    }

}
