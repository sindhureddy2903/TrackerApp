package io.tracking.service;


import io.tracking.entity.Readings;

import java.util.List;

public interface ReadingsService {
    List<Readings> findAll();

    Readings findOne(String vin);

    Readings create(Readings reading);

    Readings update(String id, Readings readings);

    void delete(String vin);
}
