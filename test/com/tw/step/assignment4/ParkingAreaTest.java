package com.tw.step.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingAreaTest {
    @Test
    void shouldPark() {
        ParkingArea parkingArea = new ParkingArea(2);
        assertEquals(ParkingStatus.PARKED, parkingArea.park());
    }

    @Test
    void shouldNotParkIfSlotIsNotAvailable() {
        ParkingArea parkingArea = new ParkingArea(1);
        parkingArea.park();
        assertEquals(ParkingStatus.NOT_PARKED,parkingArea.park());
    }

    @Test
    void shouldGiveStatusOfSlotAvailability() {
        ParkingArea parkingArea = new ParkingArea(1);
        assertTrue(parkingArea.areSlotsAvailable());

        parkingArea.park();
        assertFalse(parkingArea.areSlotsAvailable());
    }
}