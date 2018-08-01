package com.codecool.services;

import com.codecool.model.Brand;
import com.codecool.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ModelService {
        EntityManager em;

    public ModelService(EntityManager em) {
        this.em = em;
    }

    public List<Model> getAllModels(Long id) {
        List<Model> models = em.createQuery("SELECT b.models FROM Brand b WHERE b.id=:id")
                .setParameter("id", id)
                .getResultList();
        return models;
    }

    public Model getModelById(Long id) {
        return em.find(Model.class, id);
    }

    public void saveModel(Long id, Model model) {
        System.out.println(model.toString());
        Brand brand = em.find(Brand.class, id);
        model.setBrand(brand);
        em.getTransaction().begin();
        em.persist(model);
        em.getTransaction().commit();
    }
}
