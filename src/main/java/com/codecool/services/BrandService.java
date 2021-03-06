package com.codecool.services;

import com.codecool.model.Brand;
import com.codecool.model.Producer;

import javax.persistence.*;
import java.util.List;

public class BrandService {

    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("carcheck");
        return emf.createEntityManager();
    }

    public Brand createBrand(Brand brand) {
        EntityManager em = getEntityManager();
        em.getTransaction();
        em.persist(brand);
        em.close();

        return brand;
    }

    public void removeBrand(long id) {
        EntityManager em = getEntityManager();
        Brand brandToDel = em.find(Brand.class, id);

        if (brandToDel != null) {
            brandToDel.setProducer(null);
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(brandToDel);
            transaction.commit();
            em.close();
        }
    }

    public Brand findBrand(long id) {
        EntityManager em = getEntityManager();
        Brand brand = em.find(Brand.class, id);
        em.close();
        return brand;
    }

    public List<Brand> getAllBrands(long id) {
        EntityManager em = getEntityManager();
        List<Brand> brands = em.createQuery("SELECT b.brandsList FROM Producer b WHERE b.id=:id")
                .setParameter("id", id)
                .getResultList();
        return brands;
    }

    public Brand addBrand(long producerId, Brand brand) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Producer brandProducer = em.find(Producer.class, producerId);
        brand.setProducer(brandProducer);

        transaction.begin();
        em.persist(brand);
        transaction.commit();
        em.close();
        return brand;
    }

    public Brand updateBrand(long brandId, Brand brand) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Brand updatedBrand = em.find(Brand.class, brandId);
        updatedBrand.setBrandName(brand.getBrandName());


        transaction.begin();
        em.merge(updatedBrand);
        transaction.commit();
        em.close();
        return updatedBrand;
    }
}