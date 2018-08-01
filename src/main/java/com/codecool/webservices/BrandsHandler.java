package com.codecool.webservices;

import com.codecool.model.Brand;
import com.codecool.services.BrandService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/brands")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BrandsHandler {
    BrandService bs;

    public BrandsHandler() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("carcheck");
        EntityManager em = emf.createEntityManager();
        this.bs = new BrandService(em);
    }

    @GET
    @Path("{id}")
    public Brand getBrandById(@PathParam("id") long id) {
        Brand brand = bs.findBrand(id);
        return brand;
    }

    @DELETE
    @Path("{id}")
    public void deleteBrand(@PathParam("id") long id) {
        bs.removeBrand(id);
    }

}
