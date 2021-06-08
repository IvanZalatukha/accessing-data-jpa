package com.example.accessingdatajpa.controller;

import com.example.accessingdatajpa.entity.Parking;
import com.example.accessingdatajpa.service.ParkingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api
public class ParkingController {
    @Autowired
    private ParkingService parkingService;

    @GetMapping(path = "/parkings", //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    public List<Parking> getParkings() {
        System.out.println("(Service Side) Get all parkings with name: " + parkingService.getAll());
        return parkingService.getAll();
    }


    @RequestMapping(value = "/parking/{id}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Parking getParking(@PathVariable("id") Long id) {
        System.out.println("(Service Side) getById parking with getById(parkId) " + parkingService.getById(id));
        return parkingService.getById(id);
    }

    @RequestMapping(value = "/parking", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Parking addParking(@RequestBody Parking parking) {

        System.out.println("(Service Side) Creating parking with name: " + parking.getName());

        return parkingService.addParking(parking);
    }

    @RequestMapping(value = "/parking", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Parking updateParking(@RequestBody Parking parking) {

        System.out.println("(Service Side) Updating parking with name: " + parking.getName());

        return parkingService.updateParking(parking);
    }

    @RequestMapping(value = "/parking/{id}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteEmployee(@PathVariable("id") Long id) {

        System.out.println("(Service Side) Deleting parking with Id: " + id);

        parkingService.delete(id);
    }


}
