package com.codecool.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "brand")
@XmlRootElement
public class Brand{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String brandName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Producer producer;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Brand> brands = new HashSet<>();

    public Brand(String producerName) {
        this.brandName = producerName;
    }

    public Brand() {

    }

    public long getId() {
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

    public Set<Brand> getBrands() {
        return brands;
    }

    public void setBrands(Set<Brand> brands) {
        this.brands = brands;
    }
}

