package com.codecool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "brand")
@XmlRootElement
public class Brand{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String brandName;

    public Brand(long id, String producerName) {
        this.id = id;
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
}

