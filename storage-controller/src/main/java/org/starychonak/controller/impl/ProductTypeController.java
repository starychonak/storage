package org.starychonak.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.starychonak.controller.ProductTypeApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.starychonak.dto.ProductDTO;
import org.starychonak.dto.ProductTypeDTO;
import org.starychonak.mapper.ProductTypeDTOMapper;
import org.starychonak.model.ProductType;
import org.starychonak.repository.ProductTypeRepository;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductTypeController implements ProductTypeApi {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ProductTypeDTOMapper productTypeDTOMapper;

    @Override
    public ResponseEntity<ProductTypeDTO> createProductType(ProductTypeDTO body) {
        ProductType productType = productTypeDTOMapper.fromDTO(body);
        productTypeRepository.createProductType(productType);
        return ResponseEntity.ok(body);
    }

    @Override
    public ResponseEntity<ProductTypeDTO> findById(String id) {
        ProductTypeDTO productTypeDTO = productTypeDTOMapper.toDTO(productTypeRepository.findById(id));
        return ResponseEntity.ok(productTypeDTO);
    }

    @Override
    public ResponseEntity<List<ProductTypeDTO>> findAll() {
        List<ProductTypeDTO> productTypeDTO = productTypeDTOMapper.toListDTO(productTypeRepository.findAll());
        return ResponseEntity.ok(productTypeDTO);
    }

    //
//    @Override
//    public ResponseEntity<Object> getProductById(Long id) {
//        return ProductTypeApi.super.getProductById(id);
//    }
//
//    @Override
//    public ResponseEntity<Object> getProducts(String name, ProductType type, BigDecimal minCost, BigDecimal maxCost, Long quantity, Long size) {
//        return ProductTypeApi.super.getProducts(name, type, minCost, maxCost, quantity, size);
//    }
//
//    @Override
//    public ResponseEntity<Object> removeProduct(Long id) {
//        return ProductTypeApi.super.removeProduct(id);
//    }
}
