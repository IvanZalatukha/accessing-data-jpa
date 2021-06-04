package com.example.accessingdatajpa;

import com.example.accessingdatajpa.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
