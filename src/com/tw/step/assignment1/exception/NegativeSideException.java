package com.tw.step.assignment1.exception;

public class NegativeSideException extends Throwable {
    public NegativeSideException(double side) {
        super(
                String.format("Invalid argument %f", side)
        );
    }
}
