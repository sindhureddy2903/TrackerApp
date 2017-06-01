package io.tracking.service;


import io.tracking.entity.Vehicles;

import java.util.List;

public interface VehiclesService {
    List<Vehicles> findAll();

    Vehicles findOne(String vin);

    Vehicles create(Vehicles[] vehicles);

//    Vehicles update(String vin, Vehicles[] vehicles);

    void delete(String vin);
}
