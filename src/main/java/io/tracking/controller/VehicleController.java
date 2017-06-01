package io.tracking.controller;

import io.tracking.entity.Readings;
import io.tracking.service.ReadingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "readings")
public class VehicleController {
    @Autowired
    private ReadingsService service;

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Readings> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings findOne(@PathVariable("vin") String vin) {
        return service.findOne(vin);
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings create(@RequestBody Readings reading) {
        return service.create(reading);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{vin}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings update(@PathVariable("vin") String vin, @RequestBody Readings reading) {
        return service.update(vin, reading);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{vin}")
    public void delete(@PathVariable("vin") String vin) {
        service.delete(vin);
    }
}
