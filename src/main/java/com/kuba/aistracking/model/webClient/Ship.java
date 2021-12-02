package com.kuba.aistracking.model.webClient;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Ship {

    private double positionY;
    private double positionX;
    private String name;



}
