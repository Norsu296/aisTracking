package com.kuba.aistracking.controller;

import com.kuba.aistracking.model.webClient.Ship;
import com.kuba.aistracking.service.webClient.ShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;

    @GetMapping()
    public List<Ship> findAll() {
        return shipService.getShipPositions();
    }

}
