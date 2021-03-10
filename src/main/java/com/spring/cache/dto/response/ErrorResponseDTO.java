package com.spring.cache.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@RequiredArgsConstructor
public class ErrorResponseDTO implements Serializable{
    private final String errorType;
    private final String message;
}
