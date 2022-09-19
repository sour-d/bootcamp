package com.tw.step.assignment5;

import com.tw.step.assignment5.execption.BagLimitExceededException;
import com.tw.step.assignment5.execption.ColorLimitExceedException;

import java.util.HashSet;

public class Bag {
    private final HashSet<Ball> balls;
    private final int maxBalls;

    public Bag(int maxBalls) {
        this.maxBalls = maxBalls;
        this.balls = new HashSet<>();
    }

    public int addBall(Ball ball) throws ColorLimitExceedException, BagLimitExceededException {
        if(this.isBagFull()) {
            throw new BagLimitExceededException(maxBalls);
        }

        if (isSameBallLimitExceeded(ball)) {
            throw new ColorLimitExceedException(ball.getColor());
        }

        balls.add(ball);
        return balls.size();

    }

    private boolean isSameBallLimitExceeded(Ball ball) {
        Color ballColor = ball.getColor();
        return ball.colorLimit() == this.countSameColoredBall(ballColor);
    }

    private boolean isBagFull() {
        return this.balls.size() == maxBalls;
    }

    private long countSameColoredBall(Color ballColor) {
        return this.balls.stream()
                .filter(ball -> ball.getColor() == ballColor)
                .count();
    }
}
