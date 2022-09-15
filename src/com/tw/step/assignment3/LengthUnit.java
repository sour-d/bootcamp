package com.tw.step.assignment3;

public enum LengthUnit {
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

    public double convertToBaseUnit(double length) {
        return length;
    }
}
