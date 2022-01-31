package com.ecommerce.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ValidationErrorDto {
    private String field;
    private String message;
}
