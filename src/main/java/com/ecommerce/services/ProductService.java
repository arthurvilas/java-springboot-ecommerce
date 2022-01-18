package com.ecommerce.services;

import java.util.List;
import java.util.Optional;

import com.ecommerce.models.Product;
import com.ecommerce.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }
}
