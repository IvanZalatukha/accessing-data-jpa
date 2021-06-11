package com.example.accessingdatajpa.controller;

import com.example.accessingdatajpa.entity.Parking;
import com.example.accessingdatajpa.service.ParkingService;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping(path = "/parkings", //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<Parking> getParkings() {
        System.out.println("(Service Side) Get all parkings with name: " + parkingService.getAll());
        return parkingService.getAll();
    }


    @GetMapping(value = "/parking/{id}", //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Optional<Parking> getParking(@PathVariable("id") Long id) {
        System.out.println("(Service Side) getById parking with getById(parkId) " + parkingService.getById(id));
        return parkingService.getById(id);
    }

    @PostMapping(value = "/parking", //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Parking addParking(@RequestBody Parking parking) {
        System.out.println("(Service Side) Creating parking with name: " + parking.getName());
        return parkingService.addParking(parking);
    }

    @PutMapping(value = "/parking", //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Parking updateParking(@RequestBody Parking parking) {
        System.out.println("(Service Side) Updating parking with name: " + parking.getName());
        return parkingService.updateParking(parking);
    }

    @DeleteMapping(value = "/parking/{id}", //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public void deleteEmployee(@PathVariable("id") Long id) {
        System.out.println("(Service Side) Deleting parking with Id: " + id);
        parkingService.delete(id);
    }


}
