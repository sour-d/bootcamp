package com.tw.step.assignment5;

public class Ball {
    private Color color;

    public Ball(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public int colorLimit(){
        return this.color.getMax();
    }
}
