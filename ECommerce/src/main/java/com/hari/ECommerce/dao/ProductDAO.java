package com.hari.ECommerce.dao;

import com.hari.ECommerce.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDAO {

    public Product toProductResponse(Product product){
        return Product.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }

    public List<Product> toProductResponseList(List<Product> products){
        return products.stream().map(this::toProductResponse).collect(Collectors.toList());
    }
}
