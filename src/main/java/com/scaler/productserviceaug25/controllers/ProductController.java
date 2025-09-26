package com.scaler.productserviceaug25.controllers;

import com.scaler.productserviceaug25.commons.AuthCommons;
import com.scaler.productserviceaug25.exceptions.ProductNotFoundException;
import com.scaler.productserviceaug25.models.Product;
import com.scaler.productserviceaug25.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

// localhost:8080/products
@RestController
@RequestMapping("/products") // endpoint - /products
public class ProductController {
    private ProductService productService;
    private RestTemplate restTemplate;

    public ProductController(ProductService productService,
                             RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    // localhost:8080/products/1
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException {
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

//        System.out.println("DEBUG");
//        Product product = productService.getSingleProduct(productId); // @16640
//
//        Product p = new Product(); // @16736
//        p.setId(productId);
//        p.setTitle("iPhone 14 pro max.");
//        p.setDescription("iPhone 14 pro max.");
//        p.setPrice(130000.0);
//
//        return p;

        System.out.println("getSingleProduct API called in ProductController!");

        //make a demo call to User
        //Instead of hardcoding the url of UserService, we should fetch the list of
        //IP addresses of UserService from Service Discovery and then make a call
        //to UserService in a load balanced way.
        restTemplate.getForEntity(
                "http://userservicesept25/users/sample",
                Void.class
        );

        Product product = null;
        ResponseEntity<Product> responseEntity = null;
//        if (AuthCommons.validateToken(tokenValue)) {
            product = productService.getSingleProduct(productId);
            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        } else {
            responseEntity = new ResponseEntity<>(product, HttpStatus.UNAUTHORIZED);
//        }

        return responseEntity;
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

    // http://localhost:8080/products/title/iphone
    @GetMapping("/title/{title}/{pageNumber}/{pageSize}")
    public Page<Product> getProductsByTitle(
            @PathVariable("title") String title,
            @PathVariable("pageNumber") int pageNumber,
            @PathVariable("pageSize") int pageSize) {

        return productService.getProductsByTitle(title, pageNumber, pageSize);
    }
}
