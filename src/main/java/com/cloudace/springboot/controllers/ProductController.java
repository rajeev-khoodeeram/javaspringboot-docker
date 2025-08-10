package com.cloudace.springboot.controllers;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloudace.springboot.model.Product;
import com.cloudace.springboot.services.ProductService;


@RestController
public class ProductController {

    // This class will handle product-related requests
    // For example, methods to create, read, update, and delete products


    
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        // This method will return a product based on the provided id
        // For now, it will just return a dummy product
       
       //Product product = new Product(); 
       /* 
       product.setName("Product " + id);
       product.setDescription("This is product " + id);
       product.setPrice(34.50);
       */
         // Logic to retrieve a product by its ID
       Product product;  
       ProductService productService = new ProductService();
       product = productService.getProductById(id);  

      if (product.getName().length() == 0) {
        return ResponseEntity.notFound().build();
      }
      return new ResponseEntity<>(product, HttpStatus.OK);

      // / return product;
    }
        
    
    // Additional methods can be added here as needed
    // For example, to list all products, add a new product, etc.
    // Placeholder for product list
    @GetMapping("/products")
    public List<Product> getAllProducts() { 
        // Logic to retrieve all products
        // For now, returning a sample list; use for JUnit tests
        //List<Product> products = new ArrayList<>();
        // products.add(new Product(1L, "Sample Product", "This is a sample product description", 19.99));
        // products.add(new Product(2L, "Another Product", "This is another product description", 29.99));
    

        ProductService productService = new ProductService();
        List<Product> products = productService.getAllProducts(); // Use the service to get products
        return  products; // Returning an empty list for now
     }

    @PostMapping("/products")
     public ResponseEntity<Product> addProduct(@RequestBody Product product) { 
        ProductService productService = new ProductService();
        
          if (product.getName().length() ==0)  
          return ResponseEntity.badRequest().build();
          else{
          Product nProduct =productService.addProduct(product);
          return ResponseEntity.status(HttpStatus.CREATED).body(nProduct);
          }
      }
    // public void updateProduct(Long id, Product product) { ... }
    // public void deleteProduct(Long id) { ... }

    
}


