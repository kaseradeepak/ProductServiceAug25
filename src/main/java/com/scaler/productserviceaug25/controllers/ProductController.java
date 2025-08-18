package com.scaler.productserviceaug25.controllers;

import com.scaler.productserviceaug25.exceptions.ProductNotFoundException;
import com.scaler.productserviceaug25.models.Product;
import com.scaler.productserviceaug25.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// localhost:8080/products
@RestController
@RequestMapping("/products") // endpoint - /products
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    // localhost:8080/products/1
    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException {
//        try {
//            Product product = productService.getSingleProduct(productId);
//
//            return new ResponseEntity<>(
//                    product,
//                    HttpStatus.OK
//            );
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(
//                    null,
//                    HttpStatus.INTERNAL_SERVER_ERROR
//            );
//        }

        return productService.getSingleProduct(productId);

        // HTTPStatus Code - 200, 404, 403, 500, 429, ....
    }

    // localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // localhost:8080/products
    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long productId, @RequestBody Product product) {
        return null;
    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<String> handleProductNotFoundException() {
//        return new ResponseEntity<>(
//                "Product not found, please try again",
//                HttpStatus.NOT_FOUND
//        );
//    }
}
