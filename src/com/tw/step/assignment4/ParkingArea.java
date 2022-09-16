package com.tw.step.assignment4;

public class ParkingArea {
    private final int totalSlots;
    private int parkedSlots;

    public ParkingArea(int totalSlots) {
        this.totalSlots = totalSlots;
        this.parkedSlots = 0;
    }

    public ParkingStatus park() {
        if (this.areSlotsAvailable()) {
            this.parkedSlots++;
            return ParkingStatus.PARKED;
        }
        return ParkingStatus.NOT_PARKED;
    }

    boolean areSlotsAvailable() {
        return this.totalSlots > this.parkedSlots;
    }
}
