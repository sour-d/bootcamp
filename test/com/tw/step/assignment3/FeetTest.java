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


        assertEquals(Outcome.EQUAL,feet.compare(inch));
        assertEquals(Outcome.GREATER,feet.compare(inch2));
        assertEquals(Outcome.LESSER,feet.compare(inch1));
    }

    @Test
    void shouldCompareInchAndCentimeter() {
        Length inch = new Length(2,Unit.IN);
        Length centimeter = new Length(5,Unit.CM);
        Length centimeter1 = new Length(4,Unit.CM);
        Length centimeter2 = new Length(6,Unit.CM);

        assertEquals(Outcome.EQUAL,inch.compare(centimeter));
        assertEquals(Outcome.GREATER,inch.compare(centimeter1));
        assertEquals(Outcome.LESSER,inch.compare(centimeter2));
    }

    @Test
    void shouldCompareCentimeterAndMilliMeter() {
        Length centimeter = new Length(1,Unit.CM);
        Length millimeter = new Length(10,Unit.MM);
        Length millimeter1 = new Length(8,Unit.MM);
        Length millimeter2 = new Length(11,Unit.MM);


        assertEquals(Outcome.EQUAL,centimeter.compare(millimeter));
        assertEquals(Outcome.GREATER,centimeter.compare(millimeter1));
        assertEquals(Outcome.LESSER,centimeter.compare(millimeter2));
    }

    @Test
    void shouldCompareMillimeterAndInch() {
        Length millimeter = new Length(100,Unit.MM);
        Length inch = new Length(4,Unit.IN);
        Length inch1 = new Length(3,Unit.IN);
        Length inch2 = new Length(5,Unit.IN);


        assertEquals(Outcome.EQUAL,millimeter.compare(inch));
        assertEquals(Outcome.GREATER,millimeter.compare(inch1));
        assertEquals(Outcome.LESSER,millimeter.compare(inch2));
    }
}