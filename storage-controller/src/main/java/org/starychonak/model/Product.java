package org.starychonak.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    Long id;
    String name;
    ProductType type;
    Long quantity;
    BigDecimal cost;
}
