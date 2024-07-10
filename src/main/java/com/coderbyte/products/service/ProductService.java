package com.coderbyte.products.service;

import com.coderbyte.products.dto.ProductDTO;
import com.coderbyte.products.model.Product;
import com.coderbyte.products.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Mono<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id)
                .map(this::toDTO);
    }

    private ProductDTO toDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        return dto;
    }
}
