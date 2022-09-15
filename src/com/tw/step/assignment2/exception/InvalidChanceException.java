package com.tw.step.assignment2.exception;

public class InvalidChanceException extends Throwable {
    public InvalidChanceException(double chance) {
        super(String.format("Invalid chance %f. Chance should be between 0-1.",chance));
    }
}
