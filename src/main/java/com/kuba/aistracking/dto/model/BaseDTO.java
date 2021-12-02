package com.kuba.aistracking.dto.model;

import lombok.*;

@Data
public class BaseDTO {

    private Long id;
    private double positionX;
    private double positionY;
    private String name;
}
