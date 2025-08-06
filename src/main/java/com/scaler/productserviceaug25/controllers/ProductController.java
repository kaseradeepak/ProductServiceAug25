package com.scaler.productserviceaug25.controllers;

import com.scaler.productserviceaug25.models.Product;
import com.scaler.productserviceaug25.services.FakeStoreProductService;
import com.scaler.productserviceaug25.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// localhost:8080/products
@RestController
@RequestMapping("/products") // endpoint - /products
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // localhost:8080/products/1
    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") Long productId) {
        return productService.getSingleProduct(productId);
    }

    // localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

    // localhost:8080/products
    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return null;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long productId, @RequestBody Product product) {
        return null;
    }
}
