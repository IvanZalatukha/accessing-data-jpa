package com.example.accessingdatajpa.service.impl;

import com.example.accessingdatajpa.dao.ParkingRepository;
import com.example.accessingdatajpa.entity.Parking;
import com.example.accessingdatajpa.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

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
    public Parking getById(Long id) {
        return parkingRepository.getOne(id);
    }

    @Override
    public Parking updateParking(Parking parking) {
        return parkingRepository.saveAndFlush(parking);
    }

    @Override
    public List<Parking> getAll() {
        return parkingRepository.findAll();
    }
}
