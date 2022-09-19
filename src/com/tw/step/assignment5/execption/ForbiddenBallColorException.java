package com.tw.step.assignment5.execption;

import com.tw.step.assignment5.Color;

public class ForbiddenBallColorException extends Throwable {
    public ForbiddenBallColorException(Color color) {
        super(String.format("%s colored ball is not allowed", color));
    }
}
