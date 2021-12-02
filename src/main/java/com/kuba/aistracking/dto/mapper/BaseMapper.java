package com.kuba.aistracking.dto.mapper;

import com.kuba.aistracking.dto.model.BaseDTO;
import com.kuba.aistracking.model.entity.Base;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BaseMapper {

    BaseDTO toBaseDTO(Base base);

    List<BaseDTO> toBaseDTOs(List<Base> companies);

    @InheritInverseConfiguration(name = "toBaseDTO")
    Base toBase(BaseDTO baseDTO);

    @InheritInverseConfiguration(name = "toBaseDTOs")
    List<Base> toBases(List<BaseDTO> baseDTOs);

}
