package org.starychonak.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.starychonak.dto.CustomerDTO;
import org.starychonak.dto.ProductTypeDTO;

import java.util.List;

@Tag(name = "Customer")
@RequestMapping(value = "/api/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public interface CustomerApi {

    @Operation(summary = "Редактировать клиента")
    @RequestMapping(
            value = "/edit",
            method = RequestMethod.POST)
    default ResponseEntity<Boolean> edit(@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Добавить клиента")
    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST)
    default ResponseEntity<Boolean> create(@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Получить всех клиентов")
    @RequestMapping(
            value = "/find-all",
            method = RequestMethod.GET)
    default ResponseEntity<List<CustomerDTO>> findAll(@RequestParam String name,
                                                      @RequestParam String email) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Получить клиаента по id")
    @RequestMapping(
            value = "/find-by-id",
            method = RequestMethod.GET)
    default ResponseEntity<CustomerDTO> findById(@RequestParam Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
