package com.hari.ECommerce.service;

import com.hari.ECommerce.model.Product;
import com.hari.ECommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(Product product){
        productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public void updateProduct(Long id, Product updatedProduct){
        Product product = productRepository.findById(id).orElse(null);

        if(product!=null){
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
            product.setDescription(updatedProduct.getDescription());
            productRepository.save(product);
        }
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
}
