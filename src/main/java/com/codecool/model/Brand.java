package com.codecool.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="brands")
public class Brand{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long brand_id;
    private String name;
    @OneToMany(mappedBy = "models")
    private List<Model> models = new ArrayList<>();

    public Brand(String name){
        this.name = name;
    }

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
