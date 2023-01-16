package org.starychonak.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.starychonak.dto.ProductDTO;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Tag(name = "Product")
@RequestMapping(value = "/api/product", produces =  MediaType.APPLICATION_JSON_VALUE)
@Validated
@CrossOrigin
public interface ProductApi {

    @Operation(summary = "Добавить продукт")
    @RequestMapping(
        value = "/create",
        method = RequestMethod.POST)
    default ResponseEntity<Object> createProduct(@RequestBody ProductDTO body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Получить все продукты")
    @RequestMapping(
            value = "/find-all",
            method = RequestMethod.GET)
    @Valid
    default ResponseEntity<Object> findAll(@RequestParam(required = false) String name,
                                           @RequestParam(required = false) String productType,
                                           @RequestParam(required = false) @Min(0) Long minQuantity,
                                           @RequestParam(required = false) Long maxQuantity,
                                           @RequestParam(required = false) @Min(0) BigDecimal cost,
                                           @RequestParam(required = false) Long limit) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Получить продукт по id")
    @RequestMapping(
            value = "/find-by-id",
            method = RequestMethod.GET)
    default ResponseEntity<Object> findById(@RequestParam Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Редактировать продукт")
    @RequestMapping(
            value = "/edit",
            method = RequestMethod.POST)
    default ResponseEntity<Object> editProduct(@RequestParam ProductDTO body){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
