package com.tw.step.assignment4;

import java.util.ArrayList;

public class ParkingLot {
    private final int totalSlots;
    private int parkedSlots;
    private final ArrayList<Notifiable> notifiable;

    public ParkingLot(int totalSlots) {
        this.totalSlots = totalSlots;
        this.parkedSlots = 0;
        notifiable = new ArrayList<>();
    }

    public ParkingStatus park() {
        if (this.isFull()) {
            return ParkingStatus.NOT_PARKED;
        }
        this.parkedSlots++;
        this.notifyEvent();
        return ParkingStatus.PARKED;
    }

    public boolean isFull() {
        return this.totalSlots == this.parkedSlots;
    }

    public void registerForNotification(Notifiable notifiable) {
        this.notifiable.add(notifiable);
    }

    private void notifyEvent() {
        this.notifiable.forEach(notifiable -> notifiable.notifyEvent(this));
    }

    public int getTotalSlots() {
        return totalSlots;
    }

    public int getParkedSlots() {
        return parkedSlots;
    }

}
