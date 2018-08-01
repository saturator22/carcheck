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

@Path("producers/1/brands/{id}/models")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ModelsHandler {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("carcheck");
    EntityManager em = emf.createEntityManager();

    @GET
    public List<Model> listModels(@PathParam("id") Long brandId) {
        Query query = em.createQuery("SELECT b.models FROM Brand b WHERE b.id=:id");
        query.setParameter("id", brandId);

        List<Model> modelsCollection = query.getResultList();

        return modelsCollection;
    }

//    @GET
//    @Path("{id}")
//    public Model getModelById(@PathParam("id") Integer modelId) {
//        return em.find(Model.class, modelId);
//    }
}
