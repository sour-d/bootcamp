package com.tw.step.assignment3;


public class Length {

    private double length;
    private Unit unit;

    public Length(double length,Unit unit) {
        this.length = length;
        this.unit = unit;
    }

    public int compare(Length anotherLength) {
        if (Math.round(anotherLength.toMilliMeter()) == Math.round(this.toMilliMeter())){
            return 0;
        }
        if (this.toMilliMeter() > anotherLength.toMilliMeter()) return 1;
        return -1;
    }

    public double toMilliMeter() {
        switch(unit){
            case CM: return this.length * 10;
            case IN: return this.length * 25.4;
            case FT: return this.length * 304.8;
            default: return this.length;
        }
    }

}
