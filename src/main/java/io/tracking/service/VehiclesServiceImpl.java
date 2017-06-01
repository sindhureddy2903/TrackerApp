package io.tracking.service;


import io.tracking.entity.Vehicles;
import io.tracking.exception.BadRequestException;
import io.tracking.exception.NotFoundException;
import io.tracking.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service

public class VehiclesServiceImpl implements VehiclesService {
    @Autowired
    private VehicleRepository repository;
    @Override
    @Transactional(readOnly = true)
    public List<Vehicles> findAll() {
     return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Vehicles findOne(String vin) {
        Vehicles vehicle=repository.findOne(vin);
        if(vehicle==null)
        {
            throw new NotFoundException("Vehicle with vin:"+vin+"doesnt exist");
        }
        return vehicle;
    }

    @Override
    @Transactional
    public Vehicles create(Vehicles[] vehicles) {

        for(int i = 0; i < vehicles.length; i++) {

            Vehicles vehicle = repository.findOne(vehicles[i].getVin());
            if (vehicle != null) {
                repository.update(vehicles[i]);
                //merge
            } else {
                repository.create(vehicles[i]);
            }
        }
return  null;
        }




//    @Override
//    @Transactional
//    public Vehicles update(String vin, Vehicles[] vehicles) {
//        Vehicles vehicle= repository.findOne(vin);
//        if(vehicle==null)
//        {
//            throw new BadRequestException("vehicle is not present in the data repository");
//        }
//        return repository.update(vehicles);
//    }

    @Override
    @Transactional
    public void delete(String vin) {
        Vehicles vehicle= repository.findOne(vin);
        if(vehicle==null)
        {
            throw new BadRequestException("vehicle is not present in the data repository");
        }
        repository.delete(vehicle);

    }
}
