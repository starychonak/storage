package org.starychonak.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.starychonak.dto.ProductTypeDTO;
import org.starychonak.model.ProductType;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.FIELD
)
public abstract class ProductTypeDTOMapper implements BaseDTOMapper<ProductType, ProductTypeDTO> {
}
