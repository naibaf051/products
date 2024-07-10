package com.coderbyte.products;

import com.coderbyte.products.controller.ProductController;
import com.coderbyte.products.dto.ProductDTO;
import com.coderbyte.products.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceApplicationTests {

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void contextLoads() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("Product A");
        productDTO.setPrice(10.0);

        when(productController.getProductById(1L)).thenReturn(Mono.just(productDTO));

        Mono<ProductDTO> result = productController.getProductById(1L);

        StepVerifier.create(result)
                .expectNextMatches(product -> product.getName().equals("Product A"))
                .verifyComplete();
    }
}