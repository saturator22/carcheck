package com.codecool.webservices;

import com.codecool.model.Producer;
import com.codecool.services.ProducerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/producers")
@Consumes(MediaType.APPLICATION_JSON)

public class ProducersHandler {

    private ProducerService producerService = new ProducerService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producer> getProducers() {
        return producerService.getAllProducers();
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public Response addProducer(Producer producer) {
        Producer newProducer = producerService.addProducer(producer);

        return Response.status(Response.Status.CREATED)// 201
                .entity("A new producer has been created")
                .header("Location",
                        "http://localhost:8080/producers/"
                                + String.valueOf(newProducer.getId())).build();
    }

    @PUT
    @Produces(MediaType.TEXT_HTML)
    @Path("/{producerId}")
    public Response updateProducer(@PathParam("producerId") long id, Producer producer) {
        Producer newProducer = producerService.updateProducer(id, producer);

        return Response.status(Response.Status.CREATED)// 201
                .entity("Producer has been updated")
                .header("Location",
                        "http://localhost:8080/producers/"
                                + String.valueOf(newProducer.getId())).build();
    }

    @DELETE
    @Produces(MediaType.TEXT_HTML)
    @Path("/{producerId}")
    public Response deleteProducer(@PathParam("producerId") long id) {

        if(producerService.removeProducer(id) == true) {
            return Response.status(Response.Status.OK)// 201
                    .entity("Producer has been deleted")
                    .header("Location",
                            "http://localhost:8080/producers/"
                                    + String.valueOf(id)).build();
        }
        else return Response.status(Response.Status.BAD_REQUEST)
                .entity("Producer hasn't been deleted")
                .header("Location",
                        "http://localhost:8080/producers/"
                                    + String.valueOf(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{producerId}")
    public Producer getProducer(@PathParam("producerId") long id) {
        return producerService.getProducer(id);
    }
}

