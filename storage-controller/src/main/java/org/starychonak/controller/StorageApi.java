package org.starychonak.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.starychonak.dto.ProductDTO;

@Tag(name = "Product")
@RequestMapping(value = "/api/product", produces =  MediaType.APPLICATION_JSON_VALUE)
public interface StorageApi {

    @Operation(summary = "Создать окружение")
    @RequestMapping(
        value = "",
        method = RequestMethod.POST)
    default ResponseEntity<Object> createProduct(@RequestBody ProductDTO body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
