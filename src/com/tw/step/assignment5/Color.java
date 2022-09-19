package com.tw.step.assignment5;

public enum Color {
    GREEN(3);

    private int max;

    Color(int max) {
        this.max = max;
    }

    public int getMax() {
        return max;
    }
}
