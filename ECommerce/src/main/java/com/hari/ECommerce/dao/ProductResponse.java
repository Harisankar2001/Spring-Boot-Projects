package com.hari.ECommerce.dao;

import org.springframework.stereotype.Component;

@Component
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;

    private ProductResponse(ProductResponseBuilder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.stock = builder.stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Component
    public static class ProductResponseBuilder{
        private Long id;
        private String name;
        private String description;
        private Double price;
        private Integer stock;

        public ProductResponseBuilder() {
        }


        public ProductResponseBuilder setId(Long id){
            this.id = id;
            return this;
        }

        public ProductResponseBuilder setName(String name){
            this.name = name;
            return this;
        }

        public ProductResponseBuilder setDescription(String description){
            this.description = description;
            return this;
        }

        public ProductResponseBuilder setPrice(Double price){
            this.price = price;
            return this;
        }

        public ProductResponseBuilder setStock(Integer stock){
            this.stock = stock;
            return this;
        }

        public ProductResponse build(){
            return new ProductResponse(this);
        }
    }

    public static ProductResponseBuilder builder(){
        return new ProductResponseBuilder();
    }
}
