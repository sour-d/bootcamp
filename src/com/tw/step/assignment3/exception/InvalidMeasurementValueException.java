package com.tw.step.assignment3.exception;

public class InvalidMeasurementValueException extends Throwable {
    public InvalidMeasurementValueException(double measurement) {
        super("Measurement should be positive but provided " + measurement);
    }
}
