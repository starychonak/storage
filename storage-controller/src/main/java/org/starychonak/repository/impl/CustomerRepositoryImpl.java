package org.starychonak.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.starychonak.model.Customer;
import org.starychonak.model.Product;
import org.starychonak.repository.CustomerRepository;
import org.starychonak.utils.SqlUtils;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    RowMapper<Customer> CUSTOMER_ROW_MAPPER = (rs, rowNum) ->
            Customer.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .address(rs.getString("address"))
                    .email(rs.getString("email"))
                    .build();

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public boolean create(Customer customer) {
        String sql = "insert into warehouse.\"customer\" (name, email, address) values (?, ?, ?)";
        return  jdbcTemplate.update(sql, customer.getName() , customer.getEmail(), customer.getAddress()) > 0;
    }

    @Override
    public boolean edit(Customer customer) {
        return false;
    }

    @Override
    public List<Customer> findAll(String name, String email) {
        boolean first = true;
        StringBuilder sb = new StringBuilder("select * from warehouse.\"customer\" ");
        if (StringUtils.hasLength(name)) {
            first = SqlUtils.appendLikeCondition(sb, "name", name, first);
        }
        if (StringUtils.hasLength(email)) {
            first = SqlUtils.appendLikeCondition(sb, "email", email, first);
        }

        return jdbcTemplate.query(sb.toString(), CUSTOMER_ROW_MAPPER);
    }

    @Override
    public Customer findById(Long id) {
        String sql = "select * from warehouse.\"customer\" where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, CUSTOMER_ROW_MAPPER);
    }
}
