package com.tw.step.assignment5.execption;

import com.tw.step.assignment5.BallColor;

public class ForbiddenBallColorException extends Throwable {
    public ForbiddenBallColorException(BallColor ballColor) {
        super(String.format("%s colored ball is not allowed", ballColor));
    }
}
