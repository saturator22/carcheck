package com.codecool.model;

import javax.persistence.*;
import java.util.List;

@Entity(name="brands")
public class Brand{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brand_id;
    private String name;
    @OneToMany
    private List<Model> models;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}
