package com.kuba.aistracking.controller;

import com.kuba.aistracking.dto.model.BaseDTO;
import com.kuba.aistracking.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/bases")
public class BaseController {

    private final BaseService baseService;


    @GetMapping
    public List<BaseDTO> findAll() {
        return baseService.findAll();
    }

    @GetMapping("/{id}")
    public BaseDTO findById(@PathVariable Long id) {
        return baseService.findById(id);
    }

}
