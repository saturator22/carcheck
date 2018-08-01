package com.codecool.services;

import com.codecool.model.Brand;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;

public class BrandService {
    protected EntityManager em;

    public BrandService(EntityManager em) {
        this.em = em;
    }

    public Brand createBrand(int id, String brandName) {
        Brand brand = new Brand(brandName);
        em.persist(brand);
        return brand;
    }

    public void removeBrand(int id) {
        Brand brand = findBrand(id);
        if (brand != null) {
            em.remove(brand);
        }
    }

    public Brand findBrand(int id) {
        return em.find(Brand.class, id);
    }

    public Collection<Brand> findAllBrands() {
        Query query = em.createQuery("SELECT e FROM brands e");
        return (Collection<Brand>) query.getResultList();
    }



}