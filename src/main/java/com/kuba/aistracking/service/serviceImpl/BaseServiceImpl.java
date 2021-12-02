package com.kuba.aistracking.service.serviceImpl;

import com.kuba.aistracking.dto.mapper.BaseMapper;
import com.kuba.aistracking.dto.model.BaseDTO;
import com.kuba.aistracking.exception.ControllerError;
import com.kuba.aistracking.exception.ControllerException;
import com.kuba.aistracking.repository.BaseRepository;
import com.kuba.aistracking.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BaseServiceImpl implements BaseService {

    private final BaseRepository baseRepository;
    private final BaseMapper baseMapper;

    @Override
    public List<BaseDTO> findAll() {
        return baseMapper.toBaseDTOs(baseRepository.findAll());
    }

    @Override
    public BaseDTO findById(Long id) {
        return baseMapper.toBaseDTO(baseRepository.findById(id).
                orElseThrow(() -> new ControllerException(ControllerError.BASE_NOT_FOUND)));
    }
}
