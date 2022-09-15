package com.tw.step.assignment3;

public enum TemperatureUnit {
    C,
    F{
        @Override
        public double convertToBaseUnit(double temperature) {
            return (temperature - 32)/1.8;
        }
    };

    public double convertToBaseUnit(double temperature) {
        return temperature;
    }
}
