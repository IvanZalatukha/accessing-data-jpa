package com.example.accessingdatajpa.service.impl;

import com.example.accessingdatajpa.entity.Parking;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ParkingServiceImplTest {

    @SpyBean
    private ParkingServiceImpl parkingService;

    @Test
    public void addParking() {
        Parking parking1 = new Parking( "Test Parking", 22.22, 22.22);

//        doReturn(parking1).when(parkingService.addParking(any(Parking.class)));

//        when(parkingService.addParking(any(Parking.class))).thenReturn(parking1);

        Parking parking2 = parkingService.addParking(parking1);
        assertEquals(parking1, parking2);

    }


// string for rebase test
}
