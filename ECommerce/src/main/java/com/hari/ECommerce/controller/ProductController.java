package com.hari.ECommerce.controller;

import com.hari.ECommerce.dao.ProductDAO;
import com.hari.ECommerce.dao.ProductDTO;
import com.hari.ECommerce.dao.ProductResponse;
import com.hari.ECommerce.model.Product;
import com.hari.ECommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid ProductDTO productDTO){
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product product){
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
        return new ResponseEntity<>("Product Deleted Successfully...", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllProduct(){
        productService.deleteAllProducts();
        return new ResponseEntity<>("All Product Deleted Successfully...", HttpStatus.OK);
    }
}
