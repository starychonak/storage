package org.starychonak.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.starychonak.controller.StorageApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.starychonak.dto.ProductDTO;
import org.starychonak.mapper.ProductDTOMapper;
import org.starychonak.model.Product;
import org.starychonak.repository.ProductRepository;

@RestController
public class StorageController implements StorageApi {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDTOMapper productDTOMapper;

    @Override
    public ResponseEntity<Object> createProduct(ProductDTO body) {
        Product product = productRepository.createProduct(productDTOMapper.fromDTO(body));
        return ResponseEntity.ok(productDTOMapper.toDTO(product));
    }
}
