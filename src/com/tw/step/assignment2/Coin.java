package com.tw.step.assignment2;

public class Coin {
    private final int totalHeads;
    private final int totalTails;

    public Coin(int totalHeads, int totalTails) {
        this.totalHeads = totalHeads;
        this.totalTails = totalTails;
    }

    public double possibilityOfTail() {
        double numberOfPossibilities = this.totalTails + this.totalHeads;
        return this.totalTails / numberOfPossibilities;
    }

    public double possibilityOfNotGettingTail() {
        return 1 - this.possibilityOfTail();
    }

    public double possibilityOfTailWithOtherCoin(Coin coin) {
        return this.possibilityOfTail() * coin.possibilityOfTail();
    }
}
