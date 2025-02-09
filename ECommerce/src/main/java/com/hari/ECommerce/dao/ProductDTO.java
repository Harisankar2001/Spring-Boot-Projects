package com.hari.ECommerce.dao;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


public class ProductDTO {

    @NotBlank(message = "Product name cannot be empty")
    private String name;

    @NotBlank(message = "Description is Required")
    private String description;

    @Min(value = 1, message = "Price must be greater than 0")
    private Double price;

    @Min(value = 0, message = "Stock must be non-negative")
    private Integer stock;

    public ProductDTO(Double price, Integer stock, String description, String name) {
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.name = name;
    }

    public ProductDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
