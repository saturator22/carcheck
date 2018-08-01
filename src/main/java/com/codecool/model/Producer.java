package com.codecool.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

//@Entity(name = "producer")
@XmlRootElement
public class Producer {

  //  @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String producerName;

    //@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "producer")
    private Set<Brand> brandsList = new HashSet<>();

    public Producer(String producerName, Set<Brand> brandList) {
        this.producerName = producerName;
        this.brandsList = brandList;
    }

    public Producer() {

    }

    public long getId() {
        return id;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public Set<Brand> getBrandsList() {
        return brandsList;
    }

    public void setBrandsList(Set<Brand> brandsList) {
        this.brandsList = brandsList;
    }

    public void addBrand(Brand brand) {
        brandsList.add(brand);
    }

    public void removeBrand(Brand brand) {
        brandsList.remove(brand);
    }
}
