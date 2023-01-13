package org.starychonak.mapper;

import java.util.List;

public interface BaseDTOMapper<MODEL, DTO> {
    DTO toDTO(MODEL model);

    MODEL fromDTO(DTO dto);

    List<DTO> toListDTO(List<MODEL> model);

    List<MODEL> fromListDTO(List<DTO> dto);
}

