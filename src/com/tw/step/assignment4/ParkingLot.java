package com.tw.step.assignment4;

public class ParkingArea {
    private final int totalSlots;
    private int parkedSlots;

    public ParkingArea(int totalSlots) {
        this.totalSlots = totalSlots;
        this.parkedSlots = 0;
    }

    public ParkingStatus park() {
        if (this.isLotFull()) {
            return ParkingStatus.NOT_PARKED;
        }
        this.parkedSlots++;
        return ParkingStatus.PARKED;
    }

    public boolean isLotFull() {
        return this.totalSlots == this.parkedSlots;
    }
}
