package com.tw.step.assignment3;

public class Length {
    private final double length;
    private final LengthUnit lengthUnit;

    public Length(double length, LengthUnit lengthUnit) {
        this.length = length;
        this.lengthUnit = lengthUnit;
    }

    public Outcome compare(Length anotherLength) {
        if (anotherLength.toMilliMeter() == this.toMilliMeter()){
            return Outcome.EQUAL;
        }
        if (this.toMilliMeter() > anotherLength.toMilliMeter()) return Outcome.GREATER;
        return Outcome.LESSER;
    }

    public double toMilliMeter() {
        switch(this.lengthUnit){
            case CM: return this.length * 10;
            case IN: return this.length * 25;
            case FT: return this.length * 300;
            default: return this.length;
        }
    }
}
