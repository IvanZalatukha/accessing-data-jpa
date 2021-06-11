package com.example.accessingdatajpa.service.impl;

import com.example.accessingdatajpa.dao.ParkingRepository;
import com.example.accessingdatajpa.entity.Parking;
import com.example.accessingdatajpa.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingRepository parkingRepository;

    @Autowired
    public ParkingServiceImpl(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Override
    public Parking addParking(Parking parking) {
        return parkingRepository.saveAndFlush(parking);
    }

    @Override
    public void delete(Long id) {
        parkingRepository.deleteById(id);
    }

    @Override
    public Parking getByName(String name) {
        return parkingRepository.findByName(name);
    }

    @Override
    public Optional<Parking> getById(Long id) {
        return parkingRepository.findById(id);
    }

    @Override
    public Parking updateParking(Parking parking) {
        return parkingRepository.saveAndFlush(parking);
    }

    @Override
    public List<Parking> getAll() {
        return parkingRepository.findAll();
    }

    @Override
    public void deleteAll() {
        parkingRepository.deleteAll();
    }
}
