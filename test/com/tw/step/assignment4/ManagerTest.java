package com.tw.step.assignment4;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ManagerTest {

    @Test
    void shouldManageGivenParkingLot() {
        ParkingLot mockedParkingLot = mock(ParkingLot.class);
        Manager manager = new Manager();

        manager.manage(mockedParkingLot);
        verify(mockedParkingLot).registerForNotification(manager);
    }
}