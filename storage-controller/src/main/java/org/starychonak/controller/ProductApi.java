package org.starychonak.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.starychonak.dto.ProductDTO;
import org.starychonak.model.ProductType;

import java.math.BigDecimal;

public interface ProductApi {
    default ResponseEntity<Object> editProduct(ProductDTO body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    default ResponseEntity<Object> getProductById(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    default ResponseEntity<Object> getProducts(String name,
                                               ProductType type,
                                               BigDecimal minCost,
                                               BigDecimal maxCost,
                                               Long quantity,
                                               Long size) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    default ResponseEntity<Object> removeProduct(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    };
}
