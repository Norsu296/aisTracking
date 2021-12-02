package com.kuba.aistracking.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "rockets")
public class Rocket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double range;

}
