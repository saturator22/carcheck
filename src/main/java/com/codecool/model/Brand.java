package com.codecool.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static java.util.Optional.ofNullable;

@Entity
@XmlRootElement
public class Brand{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String brandName;

    @ManyToOne
    @JsonBackReference
    private Producer producer;

    @OneToMany(mappedBy = "brand", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Model> models;

    public Brand(String brandName, Producer producer) {
        this(brandName);
        this.producer = producer;
    }

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public Brand() {

    }
//    public void updateModel(Model model, Long modelId) {
//        models.
//    }
//    public void removeModel(Model model) {
//        models.remove(model);
//    }

    public Long getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> brands) {
        this.models = brands;
    }
}


