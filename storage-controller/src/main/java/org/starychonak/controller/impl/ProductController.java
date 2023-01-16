package org.starychonak.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.starychonak.controller.ProductApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.starychonak.dto.ProductDTO;
import org.starychonak.mapper.ProductDTOMapper;
import org.starychonak.model.Product;
import org.starychonak.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController implements ProductApi {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDTOMapper productDTOMapper;

    @Override
    public ResponseEntity<Object> createProduct(@RequestBody ProductDTO body) {
        productRepository.createProduct(productDTOMapper.fromDTO(body));
        return ResponseEntity.ok(body);
    }

    @Override
    public ResponseEntity<Object> findAll(String name,
                                          String productType,
                                          Long minQuantity,
                                          Long maxQuantity,
                                          BigDecimal cost,
                                          Long limit) {
        List<Product> products = productRepository.findAll(name, productType, minQuantity, maxQuantity, cost, limit);
        return ResponseEntity.ok(productDTOMapper.toListDTO(products));
    }

    @Override
    public ResponseEntity<Object> findById(Long id) {
        ProductDTO productDTO = productDTOMapper.toDTO(productRepository.findById(id));
        return ResponseEntity.ok(productDTO);
    }


    @Override
    public ResponseEntity<Object> editProduct(ProductDTO body) {
        boolean b = productRepository.editProduct(productDTOMapper.fromDTO(body));
        return ResponseEntity.ok(body);
    }
}
