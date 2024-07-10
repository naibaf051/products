package com.coderbyte.products.controller;

import com.coderbyte.products.dto.ProductDTO;
import com.coderbyte.products.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public Mono<ProductDTO> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}