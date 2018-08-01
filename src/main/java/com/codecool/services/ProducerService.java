package com.codecool.services;

import com.codecool.model.Brand;
import com.codecool.model.Producer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class ProducerService {

//    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("carcheck");
//    private EntityManager em = emf.createEntityManager();

    private Map<Long, Producer> producers = new HashMap<>();

    public ProducerService() {
//        Set<Brand> brandList = new HashSet<>();
//        brandList.add(new Brand("test1"));
//        brandList.add(new Brand("test2"));
//
//        producers.put(1L, new Producer(1, "bmw", brandList));
//        producers.put(2L, new Producer(2, "mazda", brandList));
    }

    public List<Producer> getAllProducers() {
        return new ArrayList<Producer>(producers.values());
    }

    public Producer getProducer(long id) {
        return producers.get(id);
    }

    public Producer addProducer(Producer producer) {
        producer.setId(producers.size() + 1);
        producers.put(producer.getId(), producer);
        return producer;
    }

    public Producer updateProducer(Producer producer) {
        if (producer.getId() <= 0) {
            return null;
        }
        producers.put(producer.getId(), producer);
        return producer;
    }

    public Producer removeProducer(long id) {
        return producers.remove(id);
    }
}
