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

    public Producer getProducer(Long id) {
        return em.find(Producer.class, id);
    }

    public Producer addProducer(Producer producer) {
        transaction.begin();
        em.persist(producer);
        transaction.commit();
        return producer;
    }

    public Producer updateProducer(long id, Producer producer) {
        producer.setId(id);
        transaction.begin();
        em.merge(producer);
        transaction.commit();
        return producer;
    }

    public boolean removeProducer(long id) {
        Producer producer = getProducer(id);
        if (producer != null) {
            transaction.begin();
            em.remove(producer);
            transaction.commit();
            return true;
        }
        else return false;
    }
}
