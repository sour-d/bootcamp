package com.tw.step.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingAreaTest {
    @Test
    void shouldPark() {
        ParkingArea parkingArea = new ParkingArea();
        assertEquals("Parked",parkingArea.park());
    }
}