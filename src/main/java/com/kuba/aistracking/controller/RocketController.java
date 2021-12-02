package com.kuba.aistracking.controller;

import com.kuba.aistracking.dto.model.RocketDTO;
import com.kuba.aistracking.service.RocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/rockets")
public class RocketController {

    private final RocketService rocketService;


    @GetMapping
    public List<RocketDTO> findAll() {
        return rocketService.findAll();
    }

    @GetMapping("/{id}")
    public RocketDTO findById(@PathVariable Long id) {
        return rocketService.findById(id);
    }


}
