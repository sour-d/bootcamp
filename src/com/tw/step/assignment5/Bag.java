package com.tw.step.assignment5;

import com.tw.step.assignment5.execption.BagLimitExceededException;
import com.tw.step.assignment5.execption.ForbiddenBallColorException;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private final HashSet<Ball> balls;
    private final int maxBalls;

    public Bag(int maxBalls) {
        this.maxBalls = maxBalls;
        this.balls = new HashSet<>();
    }

    public int addBall(Ball ball) throws ForbiddenBallColorException, BagLimitExceededException {
        if(this.isBagFull()) {
            throw new BagLimitExceededException(maxBalls);
        }

        if (!isBallAllowed(ball)) {
            throw new ForbiddenBallColorException(ball.getColor());
        }

        balls.add(ball);
        return balls.size();
    }

    private boolean isBallAllowed(Ball otherBall) {
        List<BallColor> ballColors = this.balls.stream()
                .map(Ball::getColor)
                .collect(Collectors.toList());

        BallColor ballColor = otherBall.getColor();
        return ballColor.isColorAllowed(ballColors);
    }

    private boolean isBagFull() {
        return this.balls.size() == maxBalls;
    }

    private long countSameColoredBall(BallColor ballColor) {
        return this.balls.stream()
                .filter(ball -> ball.getColor() == ballColor)
                .count();
    }
}
