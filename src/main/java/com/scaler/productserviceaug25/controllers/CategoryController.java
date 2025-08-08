package com.scaler.productserviceaug25.controllers;

import com.scaler.productserviceaug25.models.Category;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable("categoryId") Long categoryId) {
        throw new RuntimeException();
    }
}
