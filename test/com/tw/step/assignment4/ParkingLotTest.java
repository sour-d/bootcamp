package com.tw.step.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ParkingLotTest {
    @Test
    void shouldPark() {
        ParkingLot parkingLot = new ParkingLot(1, 2);
        assertEquals(ParkingStatus.PARKED, parkingLot.park());
    }

    @Test
    void shouldNotifyWhileParking() {
        ParkingLot parkingLot = new ParkingLot(1, 2);
        ParkingLot mockedParkingLot = spy(parkingLot);
        mockedParkingLot.park();

        verify(mockedParkingLot).notifyEvent();
    }

    @Test
    void shouldNotParkIfSlotIsNotAvailable() {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        parkingLot.park();
        assertEquals(ParkingStatus.NOT_PARKED, parkingLot.park());
    }

    @Test
    void shouldGiveStatusOfSlotAvailability() {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        assertFalse(parkingLot.isFull());

        parkingLot.park();
        assertTrue(parkingLot.isFull());
    }

    @Test
    void shouldNotifyAllReceivers() {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        Manager mockedManager = mock(Manager.class);

        parkingLot.registerForNotification(mockedManager);
        parkingLot.notifyEvent();

        verify(mockedManager).notifyEvent(parkingLot);
    }
}