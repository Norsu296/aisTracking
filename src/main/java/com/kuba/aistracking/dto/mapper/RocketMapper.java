package com.kuba.aistracking.dto.mapper;

import com.kuba.aistracking.dto.model.RocketDTO;
import com.kuba.aistracking.model.entity.Rocket;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RocketMapper {

    RocketDTO toRocketDTO(Rocket rocket);

    List<RocketDTO> toRocketDTOs(List<Rocket> companies);

    @InheritInverseConfiguration(name = "toRocketDTO")
    Rocket toRocket(RocketDTO rocketDTO);

    @InheritInverseConfiguration(name = "toRocketDTOs")
    List<Rocket> toRockets(List<RocketDTO> rocketDTOs);


}
