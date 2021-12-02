package com.kuba.aistracking.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bases")
@Data
public class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "position_x")
    private double positionX;
    @Column(name = "position_y")
    private double positionY;
    private String name;


}
