package com.tw.step.assignment3;

import com.tw.step.assignment3.exception.InvalidMeasurementValueException;
import com.tw.step.assignment3.unit.Unit;

public class Measurement {
    private final double length;
    private final Unit unit;

    private Measurement(double length, Unit unit) {
        this.length = length;
        this.unit = unit;
    }

    public static Measurement createMeasurement(double measurement, Unit unit) throws InvalidMeasurementValueException {
        if (measurement < 0){
            throw new InvalidMeasurementValueException(measurement);
        }
        return new Measurement(measurement, unit);
    }

    public Outcome compare(Measurement otherMeasurement) throws Exception {
        validateIfSameType(otherMeasurement);

        if (otherMeasurement.convertToBaseUnit() == this.convertToBaseUnit()) {
            return Outcome.EQUAL;
        }

        if (this.convertToBaseUnit() > otherMeasurement.convertToBaseUnit()) return Outcome.GREATER;
        return Outcome.LESSER;
    }

    private void validateIfSameType(Measurement otherMeasurement) throws Exception {
        if (this.unit.getClass() != otherMeasurement.unit.getClass()){
            throw new Exception("can't match types"); // TypeMismatchException
        }
    }

    public double convertToBaseUnit() {
        return this.unit.convertToBaseUnit(this.length);
    }
}
