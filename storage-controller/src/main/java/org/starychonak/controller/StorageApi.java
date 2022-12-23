package org.starychonak.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Tag(name = "Storage")
@RequestMapping(value = "/storage", produces =  MediaType.APPLICATION_JSON_VALUE)
public interface StorageApi {

    @Operation(summary = "Создать окружение")
    @RequestMapping(
        value = "",
        method = RequestMethod.POST)
    default ResponseEntity<Object> createStorage(@RequestBody Object body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
