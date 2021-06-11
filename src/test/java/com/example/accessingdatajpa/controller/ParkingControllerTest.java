package com.example.accessingdatajpa.controller;

import com.example.accessingdatajpa.dao.ParkingRepository;
import com.example.accessingdatajpa.entity.Parking;
import com.example.accessingdatajpa.service.ParkingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ParkingController.class)
public class ParkingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParkingService parkingService;


    @Test
    public void postMethodShouldReturnStatusIsOk() throws Exception {
        Parking parking = new Parking(1L, "MY TEST PARKING", 77.77, 77.77);

        mockMvc.perform(postJson("/parking", parking))
                .andExpect(status().isOk());
    }

    public MockHttpServletRequestBuilder postJson(String uri, Object body) {
        try {
            String json = new ObjectMapper().writeValueAsString(body);
            return post(uri)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getMethodShouldReturnStatusIsOk() throws Exception {
        mockMvc.perform(get("/parkings")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void putMethodShouldReturnStatusIsOk() throws Exception {
        Parking parking = new Parking(1L, "MY TEST PARKING", 77.77, 77.77);

        mockMvc.perform(putJson("/parking", parking)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public MockHttpServletRequestBuilder putJson(String uri, Object body) {
        try {
            String json = new ObjectMapper().writeValueAsString(body);
            return put(uri)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deleteMethodShouldReturnStatusIsOk() throws Exception {

        Parking parking = new Parking(1L, "MY TEST PARKING", 77.77, 77.77);

        mockMvc.perform(delete("/parking/{id}", parking.getId()))
                .andExpect(status().isOk());
    }

}