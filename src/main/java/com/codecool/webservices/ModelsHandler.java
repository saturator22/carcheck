package com.codecool.webservices;

import com.codecool.model.Model;
import com.codecool.services.ModelService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("producers/{producerId}/brands/{brandId}/models")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ModelsHandler {
    EntityManager em;
    ModelService modelService = new ModelService(getEntityManager());

    @GET
    public List<Model> listModels(@PathParam("brandId") Long brandId) {
        List<Model> modelsById = modelService.getAllModels(brandId);
        return modelsById;
    }

    @GET
    @Path("{id}")
    public Model getModelById(@PathParam("brandId") Long brandId, @PathParam("id") Long modelId) {
        Model model = modelService.getModelById(modelId, brandId);
        return model;
    }

    @POST
    public Model addModel(@PathParam("brandId") Long id, Model model) {
        return modelService.saveModel(id, model);
    }

    @PUT
    @Path("{id}")
    public Model editModel(@PathParam("id") Long modelId, Model model) {
        return modelService.updateModel(modelId, model);
    }

    @DELETE
    @Path("{id}")
    public Model deleteModel(@PathParam("brandId") Long brandId, @PathParam("id") Long modelId) {
        System.out.println("DELETE");
        return modelService.deleteModel(modelId, brandId);
    }

    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("carcheck");
        return emf.createEntityManager();
    }
}
