package org.starychonak.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.starychonak.model.ProductType;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    Long id;
    String name;
    ProductType type;
    Long quantity;
    BigDecimal cost;
}
