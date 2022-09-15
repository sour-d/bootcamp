package com.tw.step.assignment3;

import com.tw.step.assignment3.exception.UnitMismatchException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
    @Test
    void shouldCompareFeetAndInch() {
        Length feet = new Length(1, LengthUnit.FT);
        Length inch = new Length(12, LengthUnit.IN);
        Length inch1 = new Length(20, LengthUnit.IN);
        Length inch2 = new Length(10, LengthUnit.IN);


        assertEquals(Outcome.EQUAL,feet.compare(inch));
        assertEquals(Outcome.GREATER,feet.compare(inch2));
        assertEquals(Outcome.LESSER,feet.compare(inch1));
    }

    @Test
    void shouldCompareInchAndCentimeter() {
        Length inch = new Length(2, LengthUnit.IN);
        Length centimeter = new Length(5, LengthUnit.CM);
        Length centimeter1 = new Length(4, LengthUnit.CM);
        Length centimeter2 = new Length(6, LengthUnit.CM);

        assertEquals(Outcome.EQUAL,inch.compare(centimeter));
        assertEquals(Outcome.GREATER,inch.compare(centimeter1));
        assertEquals(Outcome.LESSER,inch.compare(centimeter2));
    }

    @Test
    void shouldCompareCentimeterAndMilliMeter() {
        Length centimeter = new Length(1, LengthUnit.CM);
        Length millimeter = new Length(10, LengthUnit.MM);
        Length millimeter1 = new Length(8, LengthUnit.MM);
        Length millimeter2 = new Length(11, LengthUnit.MM);


        assertEquals(Outcome.EQUAL,centimeter.compare(millimeter));
        assertEquals(Outcome.GREATER,centimeter.compare(millimeter1));
        assertEquals(Outcome.LESSER,centimeter.compare(millimeter2));
    }

    @Test
    void shouldCompareMillimeterAndInch() {
        Length millimeter = new Length(100, LengthUnit.MM);
        Length inch = new Length(4, LengthUnit.IN);
        Length inch1 = new Length(3, LengthUnit.IN);
        Length inch2 = new Length(5, LengthUnit.IN);


        assertEquals(Outcome.EQUAL,millimeter.compare(inch));
        assertEquals(Outcome.GREATER,millimeter.compare(inch1));
        assertEquals(Outcome.LESSER,millimeter.compare(inch2));
    }

    @Test
    void shouldAddTwoInches() throws UnitMismatchException {
        Length inch = new Length(4, LengthUnit.IN);
        Length inch1 = new Length(3, LengthUnit.IN);
        Length expected = new Length(7, LengthUnit.IN);

        assertEquals(expected,inch.add(inch1));
    }

    @Test
    void shouldAddInchAndCentimeter() throws UnitMismatchException {
        Length inch = new Length(2, LengthUnit.IN);
        Length centimeter = new Length(2.5, LengthUnit.CM);
        Length expected = new Length(3, LengthUnit.IN);

        assertEquals(expected,inch.add(centimeter));
    }
}