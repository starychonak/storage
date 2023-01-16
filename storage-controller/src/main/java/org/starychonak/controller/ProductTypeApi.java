package org.starychonak.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.starychonak.dto.ProductDTO;
import org.starychonak.dto.ProductTypeDTO;
import org.starychonak.model.ProductType;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "ProductType")
@RequestMapping(value = "/api/product-type", produces =  MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public interface ProductTypeApi {

    @Operation(summary = "Добавить тип продукта")
    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST)
    default ResponseEntity<ProductTypeDTO> createProductType(@RequestBody ProductTypeDTO body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Получить тип продукта по id")
    @RequestMapping(
            value = "/find-by-id",
            method = RequestMethod.POST)
    default ResponseEntity<ProductTypeDTO> findById(@RequestParam String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Получить все типы продуктов")
    @RequestMapping(
            value = "/find-all",
            method = RequestMethod.GET)
    default ResponseEntity<List<ProductTypeDTO>> findAll() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

//    default ResponseEntity<Object> editProduct(ProductDTO body) {
//        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//    }
//
//    default ResponseEntity<Object> getProductById(Long id) {
//        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//    }
//
//
//    default ResponseEntity<Object> removeProduct(Long id) {
//        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//    };
}
