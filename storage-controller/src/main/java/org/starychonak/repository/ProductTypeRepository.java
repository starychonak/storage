package org.starychonak.repository;

import org.starychonak.model.ProductType;

import java.util.List;

public interface ProductTypeRepository {

    boolean createProductType(ProductType type);

    ProductType findById(String id);

    List<ProductType> findAll();
}
