package io.tracking.service;

import io.tracking.entity.Readings;
import io.tracking.entity.tiress;
import io.tracking.repository.ReadingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.tracking.exception.NotFoundException;
import io.tracking.exception.BadRequestException;

import java.util.List;
@Service
public class ReadingsServiceImpl implements ReadingsService {
    @Autowired
    private ReadingsRepository repository;
    @Override
    @Transactional(readOnly = true)
    public List<Readings> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Readings findOne(String vin) {
        Readings readings= repository.findOne(vin);
        if(readings==null)
        {
            throw new NotFoundException("Readings of vehicle with"+vin+"is not found");
        }
        return readings;
    }

    @Override
    @Transactional
    public Readings create(Readings reading) {
        Readings readings= repository.findOne(reading.getVin());
        if(readings != null)
        {
            throw new BadRequestException("Readings data of the car with vin number"+reading.getVin()+"is already present");
        }
        tiress tires = reading.getTires();
        return repository.create(reading, tires);

    }

    @Override
    @Transactional
    public Readings update(String vin, Readings reading) {
        Readings readings = repository.findOne(vin);
        if(readings==null)
        {
            throw new BadRequestException("A vehicle with vin number"+vin+"is not existed in the data repository");
        }
        return repository.update(reading);
    }

    @Override
    @Transactional
    public void delete(String vin) {
     Readings readings=repository.findOne(vin);
     if(readings==null)
     {
         throw new BadRequestException("the vehicle with VIN number:"+vin+"is not present in the data repository");
     }
     repository.delete(readings);
    }
}
