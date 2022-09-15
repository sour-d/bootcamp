package com.tw.step.assignment3;

public class Length {
    private double length;
    private Unit unit;

    public Length(double length,Unit unit) {
        this.length = length;
        this.unit = unit;
    }

    public Outcome compare(Length anotherLength) {
        if (anotherLength.toMilliMeter() == this.toMilliMeter()){
            return Outcome.EQUAL;
        }
        if (this.toMilliMeter() > anotherLength.toMilliMeter()) return Outcome.GREATER;
        return Outcome.LESSER;
    }

    public double toMilliMeter() {
        switch(unit){
            case CM: return this.length * 10;
            case IN: return this.length * 25;
            case FT: return this.length * 300;
            default: return this.length;
        }
    }
}
