package com.spring.cache.service;

import com.spring.cache.dto.response.ProductResponseDTO;
import com.spring.cache.exception.ProductNotFoundException;
import com.spring.cache.model.Product;
import com.spring.cache.repository.ProductRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Data
@Slf4j
@Service
@CacheConfig(cacheNames = {"Product"})
public class ProductService {
    private final ProductRepository productRepository;

    @Cacheable(key = "#id")
    public ProductResponseDTO findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(String.format("Produto não foi encontrado. id: %d", id))).toProductResponseDTO();
    }

    public ProductResponseDTO save(Product product) {
        return productRepository.save(product).toProductResponseDTO();
    }

    @CacheEvict(key = "#product.id")
    public ProductResponseDTO update(Product product) {
        this.findById(product.getId());

        return productRepository.save(product).toProductResponseDTO();
    }

    @CacheEvict(key = "#id")
    public void delete(Long id) {
        productRepository.deleteById(findById(id).getId());
    }
}
