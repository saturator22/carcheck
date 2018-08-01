package com.codecool.webservices;

import com.codecool.model.Brand;
import com.codecool.model.Model;
import com.codecool.model.Producer;
import com.codecool.services.ModelService;

import javax.naming.NamingException;
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
    EntityManager em;
    ModelService modelService = new ModelService(getEntityManager());

    @GET
    public List<Model> listModels(@PathParam("id") Long brandId) {
        em = getEntityManager();
        List<Model> modelsById = modelService.getAllModels(brandId);
        closeManagers();
        return modelsById;
    }

    @GET
    @Path("{id}")
    public Model getModelById(@PathParam("id") Long modelId) {
        em = getEntityManager();
        Model model = modelService.getModelById(modelId);
        closeManagers();
        return model;
    }
    //TODO
    @POST
    public void addModel(@PathParam("id") Long id, Model model) {
        em = getEntityManager();
        modelService.saveModel(id, model);
    }

    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("carcheck");
        return emf.createEntityManager();
    }

    private void closeManagers() {
        em.close();
    }
}
