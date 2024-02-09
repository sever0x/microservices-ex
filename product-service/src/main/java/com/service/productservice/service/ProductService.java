package com.service.productservice.service;

import com.service.productservice.dto.request.ProductRequest;
import com.service.productservice.dto.response.ProductResponse;
import com.service.productservice.mapper.ProductMapper;
import com.service.productservice.model.Product;
import com.service.productservice.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = productMapper.productRequestToProduct(productRequest);
        productRepository.save(product);

//        log.info("Product is saved = {}", product);
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::productToProductResponse)
                .toList();
    }
}
