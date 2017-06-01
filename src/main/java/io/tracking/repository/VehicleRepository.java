package io.tracking.repository;


import io.tracking.entity.Vehicles;
import io.tracking.entity.tiress;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;


public interface VehicleRepository {
    List<Vehicles> findAll();

    Vehicles findOne(String vin);



    Vehicles create(Vehicles vehicles);

    Vehicles update(Vehicles vehicles);

    void delete(Vehicles vehicles);
}
