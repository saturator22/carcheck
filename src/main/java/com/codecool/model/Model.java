package com.codecool.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Optional;

@Entity
@XmlRootElement
public class Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne//(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JsonBackReference
    private Brand brand;

    private String name;

    private String engine;

    private int horsePower;

    public Model() {

    }

    public Model(String name, String engine, int horsePower) {
        this.name = name;
        this.engine = engine;
        this.horsePower = horsePower;
    }

    public Model(String name, String engine, int horsePower, Brand brand) {
        this(name, engine, horsePower);
        this.brand = brand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}

