package com.tw.step.assignment2;

import com.tw.step.assignment2.exception.InvalidChanceException;

public class Chance {
    private final double chance;

    private Chance(double chance) {
        this.chance = chance;
    }

    public static Chance createChance(double chance) throws InvalidChanceException {
        if (chance < 0 || chance > 1) {
            throw new InvalidChanceException(chance);
        }
        return new Chance(chance);
    }

    public Chance complement() throws InvalidChanceException {
        return createChance(1 - this.chance);
    }

    public Chance and(Chance anotherChance) throws InvalidChanceException {
        double combinedChance = this.chance * anotherChance.chance;
        return createChance(combinedChance);
    }

    public Chance or(Chance anotherChance) throws InvalidChanceException {
        return this.complement()
                .and(anotherChance.complement())
                .complement();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chance chance = (Chance) o;

        return Double.compare(chance.chance, this.chance) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(chance);
        return (int) (temp ^ (temp >>> 32));
    }

    public boolean isApprox(Chance anotherChance,double delta) {
        return Math.abs(this.chance - anotherChance.chance) <= delta;
    }
}
