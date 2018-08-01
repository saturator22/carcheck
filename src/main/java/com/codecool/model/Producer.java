package com.codecool.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Producer {

    private long id;

    private String producerName;

    public Producer(long id, String producerName) {
        this.id = id;
        this.producerName = producerName;
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
}
