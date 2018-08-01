package com.codecool.webservices;

import com.codecool.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

        Model model1 = new Model("Poldon", "MOCNY W UJ", 1000);
        Model model2 = new Model("Malczan", "SLABY W UJ", 24);

        em.getTransaction().begin();
        em.persist(model1);
        em.persist(model2);
        em.getTransaction().commit();

        List<Model> modelsCollection = new ArrayList<>();
        modelsCollection.add(model1);
        modelsCollection.add(model2);
        return modelsCollection;
    }

//    @GET
//    @Path("{id}")
//    public Model getModelById(@PathParam("id") Integer modelId) {
//        return em.find(Model.class, modelId);
//    }
}
