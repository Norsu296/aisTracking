package com.kuba.aistracking.service.serviceImpl;

import com.kuba.aistracking.dto.mapper.RocketMapper;
import com.kuba.aistracking.dto.model.RocketDTO;
import com.kuba.aistracking.exception.ControllerError;
import com.kuba.aistracking.exception.ControllerException;
import com.kuba.aistracking.model.entity.Rocket;
import com.kuba.aistracking.repository.RocketRepository;
import com.kuba.aistracking.service.RocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RocketServiceImpl implements RocketService {

    private final RocketRepository rocketRepository;
    private final RocketMapper rocketMapper;

    @Override
    public List<RocketDTO> findAll() {
        return rocketMapper.toRocketDTOs(rocketRepository.findAll());
    }

    @Override
    public RocketDTO findById(Long id) {
        return rocketMapper.toRocketDTO(rocketRepository.findById(id)
                .orElseThrow(() -> new ControllerException(ControllerError.ROCKET_NOT_FOUND)));
    }
}
