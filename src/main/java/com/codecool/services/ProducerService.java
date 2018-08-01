package com.codecool.services;

import com.codecool.model.Producer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProducerService {

    private Map<Long, Producer> producers = new HashMap<>();

    public ProducerService() {
        producers.put(1L, new Producer(1, "bmw"));
        producers.put(2L, new Producer(2, "mazda"));
    }

    public List<Producer> getAllProducers() {
        return new ArrayList<Producer>(producers.values());
    }

}
