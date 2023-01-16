package org.starychonak.repository;

import org.starychonak.model.Customer;

import java.util.List;

public interface CustomerRepository {
    boolean create(Customer customer);

    boolean edit(Customer customer);

    List<Customer> findAll(String name, String email);

    Customer findById(Long id);
}
