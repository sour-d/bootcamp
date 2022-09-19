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
        Color ballColor = ball.getColor();

        if(this.balls.size() == maxBalls) {
            throw new BagLimitExceededException(maxBalls);
        }

        if (ball.colorLimit() == this.countColoredBall(ballColor)) {
            throw new ColorLimitExceedException(ball.getColor());
        }

        balls.add(ball);
        return balls.size();

    }

    private long countColoredBall(Color ballColor) {
        return this.balls.stream()
                .filter(ball -> ball.getColor() == ballColor)
                .count();
    }
}
