package com.tw.step.assignment5.execption;

import com.tw.step.assignment5.Color;

public class ColorLimitExceedException extends Throwable {
    public ColorLimitExceedException(Color color) {
        super(String.format("%s colored ball limit exceeded, limit is %d", color, color.getMax()));
    }
}
