package com.kuba.aistracking.service.webClient;

import com.kuba.aistracking.model.webClient.Ship;

import java.util.List;

public interface ShipService {

    List<Ship> getShipPositions();

}
