package com.kuba.aistracking.dto.mapper;

import com.kuba.aistracking.dto.model.RocketDTO;
import com.kuba.aistracking.model.entity.Rocket;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-02T18:49:14+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
@Component
public class RocketMapperImpl implements RocketMapper {

    @Override
    public RocketDTO toRocketDTO(Rocket rocket) {
        if ( rocket == null ) {
            return null;
        }

        RocketDTO rocketDTO = new RocketDTO();

        rocketDTO.setId( rocket.getId() );
        rocketDTO.setName( rocket.getName() );
        rocketDTO.setRange( rocket.getRange() );

        return rocketDTO;
    }

    @Override
    public List<RocketDTO> toRocketDTOs(List<Rocket> companies) {
        if ( companies == null ) {
            return null;
        }

        List<RocketDTO> list = new ArrayList<RocketDTO>( companies.size() );
        for ( Rocket rocket : companies ) {
            list.add( toRocketDTO( rocket ) );
        }

        return list;
    }

    @Override
    public Rocket toRocket(RocketDTO rocketDTO) {
        if ( rocketDTO == null ) {
            return null;
        }

        Rocket rocket = new Rocket();

        rocket.setId( rocketDTO.getId() );
        rocket.setName( rocketDTO.getName() );
        rocket.setRange( rocketDTO.getRange() );

        return rocket;
    }

    @Override
    public List<Rocket> toRockets(List<RocketDTO> rocketDTOs) {
        if ( rocketDTOs == null ) {
            return null;
        }

        List<Rocket> list = new ArrayList<Rocket>( rocketDTOs.size() );
        for ( RocketDTO rocketDTO : rocketDTOs ) {
            list.add( toRocket( rocketDTO ) );
        }

        return list;
    }
}
