package com.tw.step.assignment4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingAreaTest {
    @Test
    void shouldParkACarInParkingLotTwo() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>(Arrays.asList(parkingLot1, parkingLot2));

        ParkingArea parkingArea = new ParkingArea(parkingLots);
        assertEquals(ParkingStatus.PARKED, parkingArea.park(1));
    }

    @Test
    void determineIfParkingLotIsFull() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>(Arrays.asList(parkingLot1, parkingLot2));

        ParkingArea parkingArea = new ParkingArea(parkingLots);
        parkingArea.park(1);

        assertFalse(parkingArea.isLotFull(0));
        assertTrue(parkingArea.isLotFull(1));
    }
}