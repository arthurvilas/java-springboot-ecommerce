package com.ecommerce.config;

import com.ecommerce.models.Product;
import com.ecommerce.repositories.ProductRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository) {
        return args -> {
            // Product p1 = new Product("Chair", 350.00, "A comfy chair", "www.image.com");
            // Product p2 = new Product("Table", 500.00, "A nice table");
            //repository.saveAll(List.of(p1, p2));
        };
    }
}
