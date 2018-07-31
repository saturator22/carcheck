package com.codecool.webservices;

import com.codecool.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/producers/{producerid}/brands/{brandid}/models")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ModelsHandler {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("carchek");
    EntityManager em = emf.createEntityManager();

    @GET
    public Collection<Model> listModels(@PathParam("brandid") Integer brandId) {
        Query query = em.createQuery("SELECT m FROM model m WHERE brand_id=:id");
        query.setParameter("id", brandId);

        Collection<Model> modelsCollection = query.getResultList();
        return modelsCollection;
    }

    @GET
    @Path("{id}")
    public Model getModelById(@PathParam("id") Integer modelId) {
        return em.find(Model.class, modelId);
    }
}
