package com.example.accessingdatajpa.dao;

import com.example.accessingdatajpa.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
    @Query("select b from Parking b where b.name = :name")
    Parking findByName(@Param("name") String name);
}
