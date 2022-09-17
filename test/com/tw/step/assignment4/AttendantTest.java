package com.tw.step.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AttendantTest {

    @Test
    void shouldAssignAParkingLot() {
        ParkingLot mockedParkingLot = mock(ParkingLot.class);
        Assistant mockedAssistant = mock(Assistant.class);
        Attendant attendant = new Attendant(mockedAssistant);

        attendant.assign(mockedParkingLot);
        verify(mockedParkingLot).registerForNotification(attendant);
        verify(mockedParkingLot).registerForNotification(mockedAssistant);
    }

    @Test
    void shouldParkACar() {
        ParkingLot parkingLot1 = new ParkingLot(1, 2);
        Attendant attendant = new Attendant(new Assistant());

        attendant.assign(parkingLot1);

        assertEquals(ParkingStatus.PARKED, attendant.park(0));
    }

    @Test
    void shouldNotParkACarIfNoSlotAvailable() {
        ParkingLot parkingLot1 = new ParkingLot(1, 1);
        Attendant attendant = new Attendant(new Assistant());

        attendant.assign(parkingLot1);
        attendant.park(0);

        assertEquals(ParkingStatus.NOT_PARKED, attendant.park(0));
    }

    @Test
    void determineIfProviderLotIsFull() {
        ParkingLot parkingLot1 = new ParkingLot(1, 1);
        Attendant attendant = new Attendant(new Assistant());

        attendant.assign(parkingLot1);
        assertFalse(attendant.isLotFull(0));

        attendant.park(0);
        assertTrue(attendant.isLotFull(0));
    }
}