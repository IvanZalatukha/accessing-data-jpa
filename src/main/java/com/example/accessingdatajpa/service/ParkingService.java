package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.entity.Parking;

import java.util.List;

public interface ParkingService {
    Parking addParking(Parking parking);
    void delete(Long id);
    Parking getByName(String name);
    Parking getById(Long id);
    Parking updateParking(Parking parking);
    List<Parking> getAll();
}
