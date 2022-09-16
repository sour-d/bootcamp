package com.tw.step.assignment4;

public class Assistant implements Notifiable{
    @Override
    public void notifyEvent(ParkingLot lot) {
        System.out.println(lot.getParkedSlots() + " filled");
    }
}
