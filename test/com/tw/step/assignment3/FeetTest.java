package com.tw.step.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeetTest {
    @Test
    void shouldCompareFeetAndInch() {
        Length feet = new Length(1,Unit.FT);
        Length inch = new Length(12,Unit.IN);
        Length inch1 = new Length(20,Unit.IN);
        Length inch2 = new Length(10,Unit.IN);


        assertEquals(0,feet.compare(inch));
        assertEquals(-1,feet.compare(inch1));
        assertEquals(1,feet.compare(inch2));
    }

    @Test
    void shouldCompareInchAndCentimeter() {
        Length inch = new Length(2,Unit.IN);
        Length centimeter = new Length(5,Unit.CM);
        Length centimeter1 = new Length(4,Unit.CM);
        Length centimeter2 = new Length(6,Unit.CM);

        assertEquals(1,inch.compare(centimeter1));
        assertEquals(-1,inch.compare(centimeter2));
    }

    @Test
    void shouldCompareCentimeterAndMilliMeter() {
        Length centimeter = new Length(1,Unit.CM);
        Length millimeter = new Length(10,Unit.MM);
        Length millimeter1 = new Length(8,Unit.MM);
        Length millimeter2 = new Length(11,Unit.MM);


        assertEquals(0,centimeter.compare(millimeter));
        assertEquals(1,centimeter.compare(millimeter1));
        assertEquals(-1,centimeter.compare(millimeter2));
    }
}