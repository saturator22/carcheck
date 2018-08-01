package com.codecool.webservices;

import com.codecool.model.Brand;
import com.codecool.model.Model;
import com.codecool.model.Producer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("producers/1/brands/2/models")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ModelsHandler {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("carcheck");
    EntityManager em = emf.createEntityManager();

    @GET
    public List<Model> listModels() {
//        Query query = em.createQuery("SELECT m FROM model m WHERE brand_id=:id");
//        query.setParameter("id", brandId);
//
//        Collection<Model> modelsCollection = query.getResultList();

//        Model model1 = new Model("Poldon", "MOCNY W UJ", 1000);
//        Model model2 = new Model("Malczan", "SLABY W UJ", 24);

        Producer producer = new Producer("VW");
        Set<Brand> brandList = new HashSet<>();

        em.getTransaction().begin();
        em.persist(producer);
        em.getTransaction().commit();
        Brand brand = new Brand("Audi", em.find(Producer.class, 1L));
        em.getTransaction().begin();
        em.persist(brand);
        em.getTransaction().commit();
        Model model = new Model("A4", "moc", 654, em.find(Brand.class, 1L));
        em.getTransaction().begin();
        em.persist(model);
        em.getTransaction().commit();

        List<Model> modelsCollection = new ArrayList<>();
        modelsCollection.add(model);
        em.close();
        emf.close();

        return modelsCollection;
    }

//    @GET
//    @Path("{id}")
//    public Model getModelById(@PathParam("id") Integer modelId) {
//        return em.find(Model.class, modelId);
//    }
}
