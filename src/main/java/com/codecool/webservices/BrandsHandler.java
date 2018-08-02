package com.codecool.webservices;

import com.codecool.model.Brand;
import com.codecool.services.BrandService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("producers/{id}/")
public class BrandsHandler {
    BrandService bs;

    public BrandsHandler() {
        this.bs = new BrandService();
    }

    @GET
    @Path("/brands")
    public Collection<Brand> getAllBrands(@PathParam("id") Long producerId) {
        Collection<Brand> brands = bs.getAllBrands(producerId);
        return brands;
    }

    @GET
    @Path("/brands/{brandId}")
    public Brand getBrandById(@PathParam("brandId") long id) {
        Brand brand = bs.findBrand(id);
        return brand;
    }

    @DELETE
    @Path("/brands/{brandId}")
    public void deleteBrand(@PathParam("brandId") long id) {
        bs.removeBrand(id);
    }

    @POST
    @Path("/brands")
    public Brand addBrand(@PathParam("id") long id, Brand brand) {
        return bs.addBrand(id, brand);
    }

    @PUT
    @Path("brands/{brandId}")
    public Brand updateBrand(@PathParam("brandId") long brandId, Brand brand) {
        return bs.updateBrand(brandId, brand);
    }

}
