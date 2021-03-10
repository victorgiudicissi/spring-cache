package com.spring.cache.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductNotFoundException extends RuntimeException {
    private final String message;

    public ProductNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
