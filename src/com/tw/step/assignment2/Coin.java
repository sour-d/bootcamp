package com.tw.step.assignment2;

public class Coin {
    private final int totalHeads;
    private final int totalTails;

    public Coin(int totalHeads, int totalTails) {
        this.totalHeads = totalHeads;
        this.totalTails = totalTails;
    }

    public double chanceOfOneTail() {
        double numberOfPossibilities = this.totalTails + this.totalHeads;
        return this.totalTails / numberOfPossibilities;
    }

    public double chanceOfNotGettingOneTail() {
        return 1 - this.chanceOfOneTail();
    }

    public double chanceOfTwoTails(Coin coin) {
        return this.chanceOfOneTail() * coin.chanceOfOneTail();
    }

    public double chanceOfAtLeastOneTails(Coin coin) {
        return 1 - (this.chanceOfNotGettingOneTail() * coin.chanceOfNotGettingOneTail());
    }
}
