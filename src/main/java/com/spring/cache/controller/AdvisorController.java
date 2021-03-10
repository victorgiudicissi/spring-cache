package com.spring.cache.controller;

import com.spring.cache.dto.response.ErrorResponseDTO;
import com.spring.cache.exception.ProductNotFoundException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Order(-1)
public class AdvisorController {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponseDTO ameExceptionHandler(ProductNotFoundException ex) {
        return ErrorResponseDTO.builder().errorType(ex.getClass().getSimpleName()).message(ex.getMessage()).build();
    }
}
