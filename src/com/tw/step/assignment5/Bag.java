package com.tw.step.assignment5;

import java.util.HashSet;

public class Bag {
    private final HashSet<Ball> balls;
    private final int MAX_BALLS = 12;

    public Bag() {
        this.balls = new HashSet<>();
    }

    public boolean addBall(Ball ball){
        balls.add(ball);
        return true;
    }
}
