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
        //TODO OPTIONAL getBrand i getId do Optionala
        Optional<Model> optionalModel = Optional.ofNullable(model);
        System.out.println("PRZED IFEM " + optionalModel.map(m -> m.getBrand().getBrandName()));

        if(optionalModel.flatMap(m -> m.getBrand().getId()).orElse(0L) == brand.getId()) {
            return optionalModel;
        }

        System.out.println("PO IFIE "+optionalModel);
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
