package com.tw.step.assignment2;

public class Chance {
    private final double chance;

    public Chance(double chance) {
        this.chance = chance;
    }

    public double getChance() {
        return this.chance;
    }

    public Chance oppositeChance() {
        return new Chance(1 - this.chance);
    }

    public static Chance chanceOfTwoConsecutiveChances(Chance chance1, Chance chance2) {
        double finalChance = chance1.getChance() * chance2.getChance();
        return new Chance(finalChance);
    }

    public static Chance chanceOfAtLeastChance(Chance chance1, Chance chance2) {
        double probabilityOfFirstEvent = chance1.oppositeChance().getChance();
        double probabilityOfSecondEvent = chance2.oppositeChance().getChance();

        double finalChance = 1 - (probabilityOfFirstEvent * probabilityOfSecondEvent);
        return new Chance(finalChance);
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
}
