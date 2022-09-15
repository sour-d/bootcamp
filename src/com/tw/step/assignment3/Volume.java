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
        if (this.unit == VolumeUnit.GALLON) {
            return this.volume * 3.80;
        }
        return this.volume;
    }

    public Volume add(Volume anotherVolume) {
        double sumOfVolumes = this.toLiter() + anotherVolume.toLiter();
        return new Volume(sumOfVolumes,VolumeUnit.LITER);
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
