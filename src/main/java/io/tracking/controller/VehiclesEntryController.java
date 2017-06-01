package io.tracking.controller;


import io.tracking.entity.Vehicles;
import io.tracking.service.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "vehicles")
public class VehiclesEntryController {
    @Autowired
    private VehiclesService service;

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicles> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicles findOne(@PathVariable("vin") String vin) {
        return service.findOne(vin);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicles create(@RequestBody Vehicles[] vehicles)
    {
        System.out.println(vehicles);
        return service.create(vehicles);
    }

   @RequestMapping(method = RequestMethod.PUT, value = "{vin}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicles update(@PathVariable("vin") String vin, @RequestBody Vehicles[] vehicles) {

        return service.create(vehicles);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{vin}")
    public void delete(@PathVariable("vin") String vin) {
        service.delete(vin);
    }
}
