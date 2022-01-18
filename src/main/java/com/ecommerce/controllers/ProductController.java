package com.ecommerce.controllers;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.models.Product;
import com.ecommerce.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get a product
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Product product = productService.findById(id);
        if (product != null)
            return ResponseEntity.ok().body(product);

        return ResponseEntity.badRequest().body(null);
    }

    // // Delete a product
    // @DeleteMapping("/{id}")
    // public Product deleteProduct(@PathVariable("id") Long id) {

    // }

    // // Create a product
    // @PostMapping("/")
    // public Product createProduct(@RequestBody Product createdProduct) {

    // }

    // // Update a product
    // @PatchMapping("/{id}")
    // public Product updateProduct(@RequestBody Product updatedProduct,
    // @PathVariable("id") Long id) {

    // }

    // Get all products
    @GetMapping("/list")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> foundProducts = productService.findAll();
        return ResponseEntity.ok().body(foundProducts);
    }
}