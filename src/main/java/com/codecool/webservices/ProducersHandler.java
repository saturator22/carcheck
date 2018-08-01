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

}
