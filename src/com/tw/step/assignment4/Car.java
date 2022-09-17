package com.tw.step.assignment4;

import java.util.Objects;

public class Car {
    private final String carNumber;
    private final String color;

    public Car(String carNumber, String color) {
        this.carNumber = carNumber;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!Objects.equals(carNumber, car.carNumber)) return false;
        return Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        int result = carNumber != null ? carNumber.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
