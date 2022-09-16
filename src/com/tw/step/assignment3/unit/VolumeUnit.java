package com.tw.step.assignment3.unit;

public enum VolumeUnit implements Unit {
    GALLON {
        @Override
        public double convertToBaseUnit(double volume) {
            return volume * 3.80;
        }
    },
    LITER;

    @Override
    public double convertToBaseUnit(double volume){
        return volume;
    }
}
