package com.tw.step.assignment5.execption;

public class BagLimitExceededException extends Throwable {
    public BagLimitExceededException(int maxBalls) {
        super(String.format("Bag limit exceeded, max limit is %d", maxBalls));
    }
}
