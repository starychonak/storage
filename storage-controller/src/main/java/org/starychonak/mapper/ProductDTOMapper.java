package org.starychonak.mapper;


import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.starychonak.dto.ProductDTO;
import org.starychonak.model.Product;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    injectionStrategy = InjectionStrategy.FIELD
 )
public abstract class ProductDTOMapper implements BaseDTOMapper<Product, ProductDTO> {
}
