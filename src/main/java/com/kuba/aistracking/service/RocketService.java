package com.kuba.aistracking.service;

import com.kuba.aistracking.dto.model.RocketDTO;
import com.kuba.aistracking.model.entity.Rocket;

import java.util.List;

public interface RocketService {

    List<RocketDTO> findAll();
    RocketDTO findById(Long id);
}
