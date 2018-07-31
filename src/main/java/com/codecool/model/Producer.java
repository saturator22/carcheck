package com.codecool.model;

import javax.servlet.http.HttpServlet;

public class Producer {

    private long id;

    private String producerName;

    public Producer(long id, String producerName) {
        this.id = id;
        this.producerName = producerName;
    }

    public Producer() {

    }

}
