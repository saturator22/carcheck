package com.codecool.services;

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

    public List<Model> getAllModels(Integer id) {
        List<Model> models = em.createQuery("SELECT m FROM Model m WHERE brand_id IN :id").setParameter("id", id).getResultList();
        return models;
    }


}
