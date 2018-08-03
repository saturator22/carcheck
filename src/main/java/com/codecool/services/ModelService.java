package com.codecool.services;

import com.codecool.model.Brand;
import com.codecool.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ModelService {
        EntityManager em;
        EntityTransaction transaction;

    public ModelService(EntityManager em) {
        this.em = em;
        this.transaction = em.getTransaction();
    }

    public Model deleteModel(Long id, Long brandId) {
        Model modelToDelete = em.find(Model.class, id);
        modelToDelete.setBrand(null);

        transaction.begin();
        em.remove(modelToDelete);
        transaction.commit();

        em.close();
        return modelToDelete;
    }

    public List<Model> getAllModels(Long id) {
        List<Model> models = em.createQuery("SELECT b.models FROM Brand b WHERE b.id=:id")
                .setParameter("id", id)
                .getResultList();
        return models;
    }

    public Optional<Model> getModelById(Long id, Long brandId) {

        Brand brand = em.find(Brand.class, brandId);
        Model model = em.find(Model.class, id);

        return findOrNull(brand, model);
    }

    public Optional<Model> findOrNull(Brand brand, Model model) {
        Model nullModel = new Model("There is no model like this", null, 0);
        Optional<Model> optionalModel = Optional.of(nullModel);
        if(model == null) {
            return optionalModel;
        }

        if(model.getBrand().getId() == brand.getId()) {
            Optional<Model> availableModel = Optional.of(model);
            return availableModel;
        }

        return optionalModel;
    }

    public Model saveModel(Long id, Model model) {
        Brand brand = em.find(Brand.class, id);
        model.setBrand(brand);
        transaction.begin();
        em.persist(model);
        transaction.commit();
        closeManagers();
        return model;
    }

    public Model updateModel(Long id, Model model) {
        Model modelToUpdate = em.find(Model.class, id);
        modelToUpdate.setName(model.getName());
        modelToUpdate.setHorsePower(model.getHorsePower());
        modelToUpdate.setEngine(model.getEngine());
        transaction.begin();
        em.merge(modelToUpdate);
        transaction.commit();
        closeManagers();
        return modelToUpdate;
    }

    private void closeManagers() {
        em.close();
    }
}
