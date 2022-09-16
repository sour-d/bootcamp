package com.tw.step.assignment4;

import java.util.ArrayList;

public class Attendant implements Notifiable {
    private final ArrayList<ParkingLot> parkingLots;
    private final Assistant assistant;

    public Attendant(Assistant assistant) {
        this.parkingLots = new ArrayList<ParkingLot>();
        this.assistant = assistant;
    }

    @Override
    public void notifyEvent(ParkingLot lot) {
        if(calculatePercentage(lot) <= 20) {
            // do something
            //return
        }
        if(calculatePercentage(lot) == 100) {
            //  do something
            // return
        }
        System.out.println("got a lot");
    }

    private int calculatePercentage(ParkingLot lot) {
        return (lot.getParkedSlots() / lot.getTotalSlots()) * 100;
    }

    public void assign(ParkingLot lot) {
        lot.registerForNotification(this);
        lot.registerForNotification(this.assistant);
        this.parkingLots.add(lot);
    }

    public ParkingStatus park(int parkingLotNumber) {
        ParkingLot parkingLot = this.parkingLots.get(parkingLotNumber);
        return parkingLot.park();
    }

    public boolean isLotFull(int parkingLotNumber) {
        ParkingLot parkingLot = this.parkingLots.get(parkingLotNumber);
        return parkingLot.isFull();
    }

}
