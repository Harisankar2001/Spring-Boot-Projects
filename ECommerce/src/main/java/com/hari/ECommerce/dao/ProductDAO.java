package com.hari.ECommerce.dao;

import com.hari.ECommerce.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDAO {


    public ProductResponse toProductResponse(Product product){
        return ProductResponse.builder()
                .setId(product.getId())
                .setName(product.getName())
                .setDescription(product.getDescription())
                .setPrice(product.getPrice())
                .setStock(product.getStock()).build();
    }

    public List<ProductResponse> toProductResponseList(List<Product> products){
        return products.stream().map(
                product -> ProductResponse.builder()
                        .setId(product.getId())
                        .setName(product.getName())
                        .setDescription(product.getDescription())
                        .setPrice(product.getPrice())
                        .setStock(product.getStock())
                        .build()
        ).collect(Collectors.toList());
    }
}
