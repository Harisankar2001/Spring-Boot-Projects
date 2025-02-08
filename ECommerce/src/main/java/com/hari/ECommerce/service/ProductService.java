package com.hari.ECommerce.service;

import com.hari.ECommerce.dao.ProductDAO;
import com.hari.ECommerce.model.Product;
import com.hari.ECommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    private final ProductDAO productDAO;

    public ProductService(ProductRepository productRepository, ProductDAO productDAO) {
        this.productRepository = productRepository;
        this.productDAO = productDAO;
    }

    public Product createProduct(Product product){
        Product savedProduct = productRepository.save(product);
        return productDAO.toProductResponse(savedProduct);
    }

    public List<Product> getAllProducts(){
        return productDAO.toProductResponseList(productRepository.findAll());
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
