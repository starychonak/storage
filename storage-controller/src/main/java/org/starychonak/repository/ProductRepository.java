package org.starychonak.repository;

import org.starychonak.dto.ProductDTO;
import org.starychonak.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository {

    boolean createProduct(Product product);

    List<Product> findAll(String name, String productType, Long limit, Long maxQuantity, BigDecimal cost, Long aLong);

    Product findById(Long id);

    boolean editProduct(Product body);
}
