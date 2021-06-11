package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.entity.Parking;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ParkingService {
    Parking addParking(Parking parking);
    void delete(Long id);
    Parking getByName(String name);
    Optional<Parking> getById(Long id);
    Parking updateParking(Parking parking);
    List<Parking> getAll();

    void deleteAll();

}
