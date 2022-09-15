package com.tw.step.assignment3;

import com.tw.step.assignment3.exception.UnitMismatchException;

public class Length {
    private final double length;
    private final LengthUnit unit;

    public Length(double length, LengthUnit unit) {
        this.length = length;
        this.unit = unit;
    }

    public Outcome compare(Length anotherLength) {
        if (anotherLength.toInch() == this.toInch()) {
            return Outcome.EQUAL;
        }
        if (this.toInch() > anotherLength.toInch()) return Outcome.GREATER;
        return Outcome.LESSER;
    }

    public double toInch() {
        double equivalent = 1;

        switch (this.unit) {
            case CM: equivalent = 0.4;
                break;
            case MM: equivalent = 0.04;
                break;
            case FT: equivalent = 12;
                break;
        }
        return this.length * equivalent;
    }

    public Length add(Length anotherLength) throws UnitMismatchException {
        double sumOfLengths = this.toInch() + anotherLength.toInch();
        return new Length(sumOfLengths, LengthUnit.IN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length length1 = (Length) o;

        if (Double.compare(length1.length, length) != 0) return false;
        return unit == length1.unit;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(length);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
