package com.codecool.webservices;

import com.codecool.model.Brand;
import com.codecool.services.BrandService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    public Brand getBrandById(long id) {
        Brand brand = bs.findBrand(id);
        return brand;
    }

}
