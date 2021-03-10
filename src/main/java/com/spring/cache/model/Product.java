package com.spring.cache.model;

import com.spring.cache.dto.response.ProductResponseDTO;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String description;
    @NonNull
    private Long amountInCents;

    public ProductResponseDTO toProductResponseDTO() {
        return ProductResponseDTO.builder().id(this.id).description(this.description).amountInCents(this.amountInCents).build();
    }
}
