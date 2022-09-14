package com.tw.step.assignment1.exception;

public class NegativeHeightWidthException extends Throwable {
    public NegativeHeightWidthException(double height, double width) {
        super(
                String.format("Invalid argument %f or %f", height, width)
        );
    }
}
