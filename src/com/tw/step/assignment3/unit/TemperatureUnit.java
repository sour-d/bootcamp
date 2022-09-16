package com.tw.step.assignment3.unit;

public enum TemperatureUnit implements Unit {
    C,
    F{
        @Override
        public double convertToBaseUnit(double temperature) {
            return (temperature - 32)/1.8;
        }
    };

    @Override
    public double convertToBaseUnit(double temperature) {
        return temperature;
    }
}
