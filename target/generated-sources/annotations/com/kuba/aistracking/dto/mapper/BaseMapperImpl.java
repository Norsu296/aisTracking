package com.kuba.aistracking.dto.mapper;

import com.kuba.aistracking.dto.model.BaseDTO;
import com.kuba.aistracking.model.entity.Base;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-02T18:49:15+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
@Component
public class BaseMapperImpl implements BaseMapper {

    @Override
    public BaseDTO toBaseDTO(Base base) {
        if ( base == null ) {
            return null;
        }

        BaseDTO baseDTO = new BaseDTO();

        baseDTO.setId( base.getId() );
        baseDTO.setPositionX( base.getPositionX() );
        baseDTO.setPositionY( base.getPositionY() );
        baseDTO.setName( base.getName() );

        return baseDTO;
    }

    @Override
    public List<BaseDTO> toBaseDTOs(List<Base> companies) {
        if ( companies == null ) {
            return null;
        }

        List<BaseDTO> list = new ArrayList<BaseDTO>( companies.size() );
        for ( Base base : companies ) {
            list.add( toBaseDTO( base ) );
        }

        return list;
    }

    @Override
    public Base toBase(BaseDTO baseDTO) {
        if ( baseDTO == null ) {
            return null;
        }

        Base base = new Base();

        base.setId( baseDTO.getId() );
        base.setPositionX( baseDTO.getPositionX() );
        base.setPositionY( baseDTO.getPositionY() );
        base.setName( baseDTO.getName() );

        return base;
    }

    @Override
    public List<Base> toBases(List<BaseDTO> baseDTOs) {
        if ( baseDTOs == null ) {
            return null;
        }

        List<Base> list = new ArrayList<Base>( baseDTOs.size() );
        for ( BaseDTO baseDTO : baseDTOs ) {
            list.add( toBase( baseDTO ) );
        }

        return list;
    }
}
