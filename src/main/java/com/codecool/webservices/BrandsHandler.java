package com.codecool.webservices;

import com.codecool.model.Brand;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/producers/{id}/brands")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class BrandsHandler {
    EntityManager em;

    public BrandsHandler(EntityManager em) {
        this.em = em;
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response listBrands() {
//        Query query = em.createQuery("SELECT e FROM Professor e");
//        return query.getResultList();
//    }

    @GET
    @Path("{id}")
    public Response getBrandById(@PathParam("id") String id) {
        return Response.status(200).entity("getBrandById is called, id : " + id).build();
    }

    @PUT
    @Path("{id}")
    public Response updateBrand(@PathParam("id") long id) {
        return Response.ok("Updated brand  " + id + " :)").build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteBrand(@PathParam("id") long id) {
        return Response.ok("Deleted brand  " + id + " :)").build();
    }

    @POST
    public Response createBrand(String name) {
        Brand newBrand = new Brand(name);
        return Response.ok("Created brand").build();
    }



}
