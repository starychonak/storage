package org.starychonak.repository.impl;

import org.springframework.stereotype.Repository;
import org.starychonak.model.Product;
import org.starychonak.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public Product createProduct(Product product) {
        return product;
    }
}
