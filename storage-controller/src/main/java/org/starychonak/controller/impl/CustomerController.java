package org.starychonak.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.starychonak.controller.CustomerApi;
import org.starychonak.dto.CustomerDTO;
import org.starychonak.mapper.CustomerDTOMapper;
import org.starychonak.model.Customer;
import org.starychonak.repository.CustomerRepository;

import java.util.List;

public class CustomerController implements CustomerApi {

    @Autowired
    private CustomerDTOMapper customerDTOMapper;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public ResponseEntity<Boolean> create(CustomerDTO customerDTO) {
        Customer customer = customerDTOMapper.fromDTO(customerDTO);
        boolean created = customerRepository.create(customer);
        return ResponseEntity.ok(created);
    }

    @Override
    public ResponseEntity edit(CustomerDTO customerDTO) {
        Customer customer = customerDTOMapper.fromDTO(customerDTO);
        boolean edited = customerRepository.edit(customer);
        return ResponseEntity.ok(edited);
    }

    @Override
    public ResponseEntity<List<CustomerDTO>> findAll(String name, String email) {
        List<CustomerDTO> customerDTO = customerDTOMapper.toListDTO(customerRepository.findAll(name, email));
        return ResponseEntity.ok(customerDTO);
    }

    @Override
    public ResponseEntity<CustomerDTO> findById(Long id) {
        CustomerDTO customerDTO = customerDTOMapper.toDTO(customerRepository.findById(id));
        return ResponseEntity.ok(customerDTO);
    }
}
