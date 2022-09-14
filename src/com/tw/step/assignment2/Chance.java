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

    public Chance chanceOfTwoEvents(Chance otherEvent) {
        return new Chance(this.chance * otherEvent.getChance());
    }

    public Chance chanceOfAtLeastOneEvent(Chance otherEvent) {
        double probabilityOfFirstEvent = this.oppositeChance().getChance();
        double probabilityOfSecondEvent = otherEvent.oppositeChance().getChance();

        double chance = 1 - (probabilityOfFirstEvent * probabilityOfSecondEvent);

        return new Chance(chance);
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
