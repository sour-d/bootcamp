package com.tw.step.assignment3;

import com.tw.step.assignment3.exception.InvalidMeasurementValueException;

public class Volume {

    private final double volume;
    private final VolumeUnit unit;

    private Volume(double volume, VolumeUnit unit) {
        this.volume = volume;
        this.unit = unit;
    }

    public static Volume createVolume(double volume, VolumeUnit unit) throws InvalidMeasurementValueException {
        if (volume < 0){
            throw new InvalidMeasurementValueException(volume);
        }
        return new Volume(volume, unit);
    }

    public Outcome compare(Volume anotherVolume) {
        if (this.convertToBase() == anotherVolume.convertToBase()) return Outcome.EQUAL;
        if (this.convertToBase() < anotherVolume.convertToBase()) return Outcome.LESSER;
        return Outcome.GREATER;
    }

    private double convertToBase() {
        return this.unit.convertToBaseUnit(this.volume);
    }

    public Volume add(Volume anotherVolume) throws InvalidMeasurementValueException {
        double sumOfVolumes = this.convertToBase() + anotherVolume.convertToBase();
        return createVolume(sumOfVolumes,VolumeUnit.LITER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Volume volume1 = (Volume) o;

        if (Double.compare(volume1.volume, volume) != 0) return false;
        return unit == volume1.unit;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(volume);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
