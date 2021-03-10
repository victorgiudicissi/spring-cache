package com.spring.cache.controller;

import com.spring.cache.dto.request.ProductRequestDTO;
import com.spring.cache.dto.response.ProductResponseDTO;
import com.spring.cache.model.Product;
import com.spring.cache.service.ProductService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
public class ProductsController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@Validated @RequestBody ProductRequestDTO productRequestDTO) {
        return ResponseEntity.ok(productService.save(productRequestDTO.toProduct()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PutMapping
    public ResponseEntity<ProductResponseDTO> update(@Validated @RequestBody ProductRequestDTO productRequestDTO) {
        return ResponseEntity.ok(productService.update(productRequestDTO.toProduct()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        productService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
