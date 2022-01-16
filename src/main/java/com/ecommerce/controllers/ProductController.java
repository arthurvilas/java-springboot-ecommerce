package com.ecommerce.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.ecommerce.model.Product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products") // http://localhost:8080/products
public class ProductController {

    private List<Product> productsList = new ArrayList<>();

    // Get a product
    @GetMapping("/{id}")
    public Product product(@PathVariable("id") Long id) {
        Optional<Product> foundProduct = productsList.stream().filter(p -> p.getId() == id).findFirst();
        if (foundProduct.isEmpty()) {
            return null;
        }
        return foundProduct.get();
    }

    // Create a product
    @PostMapping("/")
    public Product product(@RequestBody Product createdProduct) {
        productsList.add(createdProduct);
        return createdProduct;
    }

    // Get all products
    @GetMapping("/list")
    public List<Product> list() {
        return productsList;
    }
}