package com.kuba.aistracking.service;

import com.kuba.aistracking.dto.model.BaseDTO;


import java.util.List;

public interface BaseService {

    List<BaseDTO> findAll();
    BaseDTO findById(Long id);

}
