package com.tw.step.assignment4;

import java.util.ArrayList;

public class ParkingArea {

    private final ArrayList<ParkingLot> parkingLots;

    public ParkingArea(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }



    public ParkingStatus park(int parkingLotNumber) {
        ParkingLot parkingLot = this.parkingLots.get(parkingLotNumber);
        return parkingLot.park();
    }

    public boolean isLotFull(int parkingLotNumber) {
        ParkingLot parkingLot = this.parkingLots.get(parkingLotNumber);
        return parkingLot.isLotFull();
    }
}
