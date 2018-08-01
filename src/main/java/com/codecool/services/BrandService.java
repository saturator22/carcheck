package com.codecool.services;

import com.codecool.model.Brand;
import com.codecool.model.Producer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrandService {

    private Map<Long, Brand> brands = new HashMap<>();

    public BrandService() {
        brands.put(1L, new Brand(1, "bmw"));
        brands.put(2L, new Brand(2, "mazda"));
    }

    public List<Brand> getAllPBrands() {
        return new ArrayList<Brand>(brands.values());
    }

    public Brand getBrand(long id) {
        return brands.get(id);
    }

    public Brand addBrand(Brand brand) {
        brand.setId(brands.size() + 1);
        brands.put(brand.getId(), brand);
        return brand;
    }

    public Brand updateBrand(Brand brand) {
        if (brand.getId() <= 0) {
            return null;
        }
        brands.put(brand.getId(), brand);
        return brand;
    }

    public Brand removeProducer(long id) {
        return brands.remove(id);
    }
}