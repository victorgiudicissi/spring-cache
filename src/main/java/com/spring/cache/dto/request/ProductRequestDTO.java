package com.spring.cache.dto.request;

import com.spring.cache.model.Product;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    private Long id;
    @NonNull
    private String description;
    @NonNull
    private Long amountInCents;

    public Product toProduct() {
        return Product.builder().id(this.id).amountInCents(this.amountInCents).description(this.description).build();
    }
}
