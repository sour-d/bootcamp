package com.tw.step.assignment5;

import com.tw.step.assignment5.Execption.ColorLimitExceedException;

import java.util.HashSet;

public class Bag {
    private final HashSet<Ball> balls;
    private final int MAX_BALLS = 12;

    public Bag() {
        this.balls = new HashSet<>();
    }

    public int addBall(Ball ball) throws ColorLimitExceedException {
        Color ballColor = ball.getColor();

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
