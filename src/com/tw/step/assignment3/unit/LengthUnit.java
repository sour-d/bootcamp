package com.tw.step.assignment3.unit;

public enum LengthUnit implements Unit {
    IN,
    FT {
        @Override
        public double convertToBaseUnit(double length) {
            return length * 12;
        }
    },
    CM {
        @Override
        public double convertToBaseUnit(double length) {
            return length * 0.4;
        }
    },
    MM {
        @Override
        public double convertToBaseUnit(double length) {
            return length * 0.04;
        }
    };

    @Override
    public double convertToBaseUnit(double length) {
        return length;
    }
}
