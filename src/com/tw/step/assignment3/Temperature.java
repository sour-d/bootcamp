package com.tw.step.assignment3;

import com.tw.step.assignment3.unit.TemperatureUnit;

public class Temperature {
    private final int temperature;
    private final TemperatureUnit unit;

    private Temperature(int temperature, TemperatureUnit unit) {
        this.temperature = temperature;
        this.unit = unit;
    }

    public static Temperature createTemperature(int temperature, TemperatureUnit unit) {
        return new Temperature(temperature, unit);
    }

    public Outcome compare(Temperature anotherTemperature) {
        if (this.convertToBaseUnit() == anotherTemperature.convertToBaseUnit()) return Outcome.EQUAL;
        if (this.convertToBaseUnit() > anotherTemperature.convertToBaseUnit()) return Outcome.GREATER;
        return Outcome.LESSER;
    }

    private double convertToBaseUnit() {
        return this.unit.convertToBaseUnit(this.temperature);
    }
}
