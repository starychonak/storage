package org.starychonak.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.starychonak.dto.CustomerDTO;
import org.starychonak.model.Customer;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.FIELD
)
public abstract class CustomerDTOMapper implements BaseDTOMapper<Customer, CustomerDTO>{
}
