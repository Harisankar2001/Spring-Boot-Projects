package com.hari.ECommerce.service;

import com.hari.ECommerce.dao.ProductDAO;
import com.hari.ECommerce.dao.ProductDTO;
import com.hari.ECommerce.dao.ProductResponse;
import com.hari.ECommerce.exception.ProductNotFoundException;
import com.hari.ECommerce.model.Product;
import com.hari.ECommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;



    @Autowired
    private final ProductDAO productDAO;

    public ProductService(ProductRepository productRepository, ProductDAO productDAO) {
        this.productRepository = productRepository;
        this.productDAO = productDAO;
    }

    public ProductResponse createProduct(ProductDTO productDTO){
        Product product = mapDTOToEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return productDAO.toProductResponse(savedProduct);
    }

    private Product mapDTOToEntity(ProductDTO productDTO){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setStock(productDTO.getStock());
        product.setPrice(productDTO.getPrice());

        return product;
    }

    public List<ProductResponse> getAllProducts(){
        List<ProductResponse> productResponses = productDAO.toProductResponseList(productRepository.findAll());

        return productResponses;
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product with ID "+id+" not found"));
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
        Product productId = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product with ID "+id+" not found"));
        productRepository.deleteById(productId.getId());
    }

    public void deleteAllProducts(){
        productRepository.deleteAll();
    }
}
