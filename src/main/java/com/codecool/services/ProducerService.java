package com.codecool.services;

import com.codecool.model.Producer;

import javax.persistence.*;
import java.util.List;

public class ProducerService {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;

    public ProducerService() {
        this.emf = Persistence.createEntityManagerFactory("carcheck");
        this.em = emf.createEntityManager();
        this.transaction = em.getTransaction();
    }

    public List<Producer> getAllProducers() {
        Query query = em.createQuery("SELECT p FROM Producer p");
        return (List<Producer>) query.getResultList();
    }

    public Producer getProducer(long id) {
        return em.find(Producer.class, id);
    }

}
