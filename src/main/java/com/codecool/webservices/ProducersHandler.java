package com.codecool.webservices;

import com.codecool.model.Producer;
import com.codecool.services.ProducerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/producers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProducersHandler {

    private ProducerService producerService = new ProducerService();

    @GET
    public List<Producer> getProducers() {
        return producerService.getAllProducers();
    }

    @POST
    public Producer addProducer(Producer producer) {
        return producerService.addProducer(producer);
    }

    @PUT
    @Path("/{producerId}")
    public Producer updateProducer(@PathParam("producerId") long id, Producer producer) {
        producer.setId(id);
        return producerService.updateProducer(producer);
    }

    @DELETE
    @Path("/{producerId}")
    public void deleteProducer(@PathParam("producerId") long id) {
        producerService.removeProducer(id);
    }


    @GET
    @Path("/{producerId}")
    public Producer getProducer(@PathParam("producerId") long id) {
        return producerService.getProducer(id);
    }
}