package com.example.accessingdatajpa.controller;

import com.example.accessingdatajpa.AccessingDataJpaApplication;
import com.example.accessingdatajpa.dao.ParkingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccessingDataJpaApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class ParkingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ParkingRepository parkingRepository;

    @Test
    public void givenEmployees_whenGetEmployees_thenStatus200() {

    }


}