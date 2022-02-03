package com.ecommerce.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Long id;

    @NotNull(message = "Name must not be null")
    @Length(min = 2, max = 20, message = "Name must have between 2 and 20 characters")
    private String name;

    @NotNull(message = "Price must not be null")
    @Min(value = 0, message = "Price must be equal or greater than 0")
    private Double price;

    @NotNull(message = "Description must not be null")
    private String description;

    @NotNull(message = "Image must not be null")
    private String image;
}
