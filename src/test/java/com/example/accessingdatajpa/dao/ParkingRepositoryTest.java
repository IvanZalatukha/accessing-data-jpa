package com.example.accessingdatajpa.dao;

import com.example.accessingdatajpa.entity.Parking;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest()
public class ParkingRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ParkingRepository parkingRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        //given
        Parking parking = new Parking("Test Parking", 22.22, 22.22);
        entityManager.persist(parking);
        entityManager.flush();
        //when
        Parking foundParking = parkingRepository.findByName(parking.getName());
        //then
        assertThat(foundParking.getName()).isEqualTo(parking.getName());


    }




}