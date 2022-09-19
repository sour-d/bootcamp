package com.tw.step.assignment5;

import com.tw.step.assignment5.execption.BagLimitExceededException;
import com.tw.step.assignment5.execption.ForbiddenBallColorException;

import java.util.HashSet;

public class Bag {
    private final HashSet<Ball> balls;
    private final int maxBalls;

    public Bag(int maxBalls) {
        this.maxBalls = maxBalls;
        this.balls = new HashSet<>();
    }

    public int addBall(Ball ball) throws ForbiddenBallColorException, BagLimitExceededException {
        if (this.isBagFull()) {
            throw new BagLimitExceededException(maxBalls);
        }

        if (!isBallAllowed(ball)) {
            throw new ForbiddenBallColorException(ball.getColor());
        }

        balls.add(ball);
        return balls.size();
    }

    private boolean isBallAllowed(Ball ball) {
        switch (ball.getColor()) {
            case GREEN:
                return canAddGreenBall();
            case RED:
                return canAddRedBall();
            case YELLOW:
                return canAddYellowBall();
            case BLACK:
                return canAddBlackBall();
            case BLUE:
                return canAddBlueBall();
        }
        return false;
    }

    private boolean isBagFull() {
        return this.balls.size() == maxBalls;
    }

    private boolean canAddGreenBall() {
        final int MAX_LIMIT = 3;
        long totalGreen = this.countExistingColor(Color.GREEN);
        return totalGreen < MAX_LIMIT;
    }

    private boolean canAddRedBall() {
        long totalGreen = this.countExistingColor(Color.GREEN);
        long totalRed = this.countExistingColor(Color.RED);

        return totalGreen * 2 > totalRed;
    }

    private boolean canAddYellowBall() {
        final double MAX_LIMIT = 40.0;
        long totalYellow = this.countExistingColor(Color.YELLOW);
        double percentageOfYellow = ((totalYellow + 1) * 100.0) / (this.balls.size() + 1);
        return percentageOfYellow < MAX_LIMIT;
    }

    private boolean canAddBlueBall() {
        long totalBlack = this.countExistingColor(Color.BLACK);
        return totalBlack < 1;
    }

    private boolean canAddBlackBall() {
        long totalBlue = this.countExistingColor(Color.BLUE);
        return totalBlue < 1;
    }

    private long countExistingColor(Color color) {
        return this.balls.stream()
                .filter(ball -> ball.getColor() == color)
                .count();
    }
}
