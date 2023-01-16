package org.starychonak.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.starychonak.dto.ProductDTO;
import org.starychonak.model.Product;
import org.starychonak.repository.ProductRepository;
import org.starychonak.utils.SqlUtils;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    RowMapper<Product> PRODUCT_ROW_MAPPER = (rs, rowNum) ->
            Product.builder()
            .id(rs.getLong("id"))
            .type(rs.getString("productType"))
            .name(rs.getString("name"))
            .cost(rs.getBigDecimal("cost"))
            .quantity(rs.getLong("quantity"))
            .build();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean createProduct(Product product) {
        String sql = "insert into warehouse.\"product\"(id, name, \"productType\", quantity, cost) values (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, product.getId(), product.getName(), product.getType(), product.getQuantity(), product.getCost()) > 0;
    }

    @Override
    public List<Product> findAll(String name, String productType, Long minQuantity, Long maxQuantity, BigDecimal cost, Long limit) {
        boolean first = true;
        String cond;
        StringBuilder sb = new StringBuilder("select * from warehouse.\"product\"");
        if (StringUtils.hasLength(name)) {
            first = SqlUtils.appendLikeCondition(sb, "name", name, first);
        }
        if (StringUtils.hasLength(productType)) {
            first = SqlUtils.appendStringCondition(sb, "productType", productType, first);
        }
        if (minQuantity != null) {
            cond = first ? "where " : "and";
            sb.append(cond + "quantity > " + minQuantity);
        }
        if (maxQuantity != null) {
            cond = first ? "where " : "and";
            sb.append(cond + "quantity < " + minQuantity);
        }
        if (cost != null) {
            first = SqlUtils.appendCondition(sb, "cost", cost, first);
        }
        if (limit != null) {
            sb.append("limit " + limit);
        }

        return jdbcTemplate.query(sb.toString(), PRODUCT_ROW_MAPPER);
    }

    @Override
    public Product findById(Long id) {
        String sql = "select * from warehouse.\"product\" where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, PRODUCT_ROW_MAPPER);
    }

    @Override
    public boolean editProduct(Product body) {
        return false;
    }
}
