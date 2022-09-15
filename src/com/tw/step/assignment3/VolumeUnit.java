package com.tw.step.assignment3;

public enum VolumeUnit {
    GALLON {
        @Override
        public double convertToBaseUnit(double volume) {
            return volume * 3.80;
        }
    },
    LITER;

    public double convertToBaseUnit(double volume){
        return volume;
    }
}
