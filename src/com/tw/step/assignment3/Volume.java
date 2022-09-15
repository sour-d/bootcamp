package com.tw.step.assignment3;

public class Volume {

    private final double volume;
    private final VolumeUnit unit;

    public Volume(double volume, VolumeUnit unit) {
        this.volume = volume;
        this.unit = unit;
    }

    public Outcome compare(Volume anotherVolume) {
        if (this.toLiter() == anotherVolume.toLiter()) return Outcome.EQUAL;
        if (this.toLiter() < anotherVolume.toLiter()) return Outcome.LESSER;
        return Outcome.GREATER;
    }

    private double toLiter() {
        switch (this.unit){
            case GALLON: return this.volume * 3.78;
            default: return this.volume;
        }
    }
}
