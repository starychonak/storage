package org.starychonak.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.starychonak.model.Product;
import org.starychonak.model.ProductType;
import org.starychonak.repository.ProductTypeRepository;

import java.util.List;

@Repository
public class ProductTypeRepositoryImpl implements ProductTypeRepository {

    RowMapper<ProductType> PRODUCT_TYPE_ROW_MAPPER = (rs, rowNum) -> new ProductType(rs.getString("type"), rs.getString("name"));

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public boolean createProductType(ProductType type) {
        String sql = "insert into warehouse.\"productType\" (type, name) values (?, ?)";
        return jdbcTemplate.update(sql, type.getType(), type.getName()) > 0;
    }

    @Override
    public ProductType findById(String id) {
        String sql = "select * from warehouse.\"productType\" where type = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, PRODUCT_TYPE_ROW_MAPPER);
    }

    @Override
    public List<ProductType> findAll() {
        String sql = "select * from warehouse.\"productType\"";
        return jdbcTemplate.query(sql, PRODUCT_TYPE_ROW_MAPPER);
    }
}
