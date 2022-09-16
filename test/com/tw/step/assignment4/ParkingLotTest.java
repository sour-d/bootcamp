package com.tw.step.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void shouldPark() {
        ParkingLot parkingLot = new ParkingLot(2);
        assertEquals(ParkingStatus.PARKED, parkingLot.park());
    }

    @Test
    void shouldNotParkIfSlotIsNotAvailable() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park();
        assertEquals(ParkingStatus.NOT_PARKED, parkingLot.park());
    }

    @Test
    void shouldGiveStatusOfSlotAvailability() {
        ParkingLot parkingLot = new ParkingLot(1);
        assertFalse(parkingLot.isLotFull());

        parkingLot.park();
        assertTrue(parkingLot.isLotFull());
    }
}