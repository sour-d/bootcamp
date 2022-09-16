package com.tw.step.assignment4;

import java.util.ArrayList;
import java.util.Objects;

public class Manager implements Notifiable {
    private final ArrayList<ParkingLot> parkingLots;

    public Manager() {
        this.parkingLots = new ArrayList<>();
    }
    
    public void manage(ParkingLot lot) {
        lot.registerForNotification(this);
        this.parkingLots.add(lot);
    }

    private int calculatePercentage(ParkingLot lot) {
        return (lot.getParkedSlots() / lot.getTotalSlots()) * 100;
    }

    @Override
    public void notifyEvent(ParkingLot lot) {
        if(calculatePercentage(lot) >= 80) {
            // do something
            return;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        return Objects.equals(parkingLots, manager.parkingLots);
    }

    @Override
    public int hashCode() {
        return parkingLots.size() > 0 ? parkingLots.hashCode() : 0;
    }
}
