package com.ecommerce.services;

import java.util.List;
import java.util.Optional;

import com.ecommerce.exceptions.NotFoundException;
import com.ecommerce.models.Product;
import com.ecommerce.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new NotFoundException("No product with id: " + id));
    }

    public Product create(Product obj) {
        return productRepository.save(obj);
    }

    public void delete(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("No product with id: " + id);
        }
    }

    public Product update(Long id, Product obj) {
        Product entity = productRepository.getById(id);
        updateData(entity, obj);
        return productRepository.save((entity));
    }

    private void updateData(Product entity, Product obj) {
        entity.setName(obj.getName());
        entity.setPrice(obj.getPrice());
        entity.setDescription(obj.getDescription());
        entity.setImage(obj.getImage());
    }
}