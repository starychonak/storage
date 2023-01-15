package org.starychonak.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.starychonak.controller.ProductApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.starychonak.dto.ProductDTO;
import org.starychonak.mapper.ProductDTOMapper;
import org.starychonak.model.Product;
import org.starychonak.model.ProductType;
import org.starychonak.repository.ProductRepository;

import java.math.BigDecimal;

@RestController
public class ProductController implements ProductApi {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDTOMapper productDTOMapper;

    @Override
    public ResponseEntity<Object> createProduct(ProductDTO body) {
        Product product = productRepository.createProduct(productDTOMapper.fromDTO(body));
        return ResponseEntity.ok(productDTOMapper.toDTO(product));
    }

    @Override
    public ResponseEntity<Object> editProduct(ProductDTO body) {
        return ProductApi.super.editProduct(body);
    }

    @Override
    public ResponseEntity<Object> getProductById(Long id) {
        return ProductApi.super.getProductById(id);
    }

    @Override
    public ResponseEntity<Object> getProducts(String name, ProductType type, BigDecimal minCost, BigDecimal maxCost, Long quantity, Long size) {
        return ProductApi.super.getProducts(name, type, minCost, maxCost, quantity, size);
    }

    @Override
    public ResponseEntity<Object> removeProduct(Long id) {
        return ProductApi.super.removeProduct(id);
    }
}
