package com.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public NotFoundErrorDto notFoundError (NotFoundException e, HttpServletRequest request) {
        NotFoundErrorDto errorDto = new NotFoundErrorDto();
        errorDto.setTimestamp(Instant.now());
        errorDto.setStatus(HttpStatus.NOT_FOUND.value());
        errorDto.setError("Not found");
        errorDto.setMessage(e.getMessage());
        errorDto.setPath(request.getRequestURI());

        return errorDto;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public List<ValidationErrorDto> validationError(MethodArgumentNotValidException e) {
        List<ValidationErrorDto> errorDtoList = new ArrayList<>();

        List<FieldError> requestErrors = e.getBindingResult().getFieldErrors();
        requestErrors.forEach(error -> {
            String field = error.getField();
            String message = error.getDefaultMessage();
            ValidationErrorDto errorDto = new ValidationErrorDto(field, message);
            errorDtoList.add(errorDto);
        });

        return errorDtoList;
    }
}