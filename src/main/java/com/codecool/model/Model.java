package com.codecool.model;

import javax.persistence.*;

@Entity
public class Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "brandId")
    private long brandId;

    private String name;

    private String engine;

    private int horsePower;

    
}

