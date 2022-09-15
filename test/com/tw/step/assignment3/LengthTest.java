package com.tw.step.assignment3;

import com.tw.step.assignment3.exception.InvalidMeasurementValueException;
import com.tw.step.assignment3.exception.UnitMismatchException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
    @Test
    void shouldCompareFeetAndInch() throws InvalidMeasurementValueException {
        Length feet = Length.createLength(1, LengthUnit.FT);
        Length inch = Length.createLength(12, LengthUnit.IN);
        Length inch1 = Length.createLength(20, LengthUnit.IN);
        Length inch2 = Length.createLength(10, LengthUnit.IN);


        assertEquals(Outcome.EQUAL,feet.compare(inch));
        assertEquals(Outcome.GREATER,feet.compare(inch2));
        assertEquals(Outcome.LESSER,feet.compare(inch1));
    }

    @Test
    void shouldCompareInchAndCentimeter() throws InvalidMeasurementValueException {
        Length inch = Length.createLength(2, LengthUnit.IN);
        Length centimeter = Length.createLength(5, LengthUnit.CM);
        Length centimeter1 = Length.createLength(4, LengthUnit.CM);
        Length centimeter2 = Length.createLength(6, LengthUnit.CM);

        assertEquals(Outcome.EQUAL,inch.compare(centimeter));
        assertEquals(Outcome.GREATER,inch.compare(centimeter1));
        assertEquals(Outcome.LESSER,inch.compare(centimeter2));
    }

    @Test
    void shouldCompareCentimeterAndMilliMeter() throws InvalidMeasurementValueException {
        Length centimeter = Length.createLength(1, LengthUnit.CM);
        Length millimeter = Length.createLength(10, LengthUnit.MM);
        Length millimeter1 = Length.createLength(8, LengthUnit.MM);
        Length millimeter2 = Length.createLength(11, LengthUnit.MM);


        assertEquals(Outcome.EQUAL,centimeter.compare(millimeter));
        assertEquals(Outcome.GREATER,centimeter.compare(millimeter1));
        assertEquals(Outcome.LESSER,centimeter.compare(millimeter2));
    }

    @Test
    void shouldCompareMillimeterAndInch() throws InvalidMeasurementValueException {
        Length millimeter = Length.createLength(100, LengthUnit.MM);
        Length inch = Length.createLength(4, LengthUnit.IN);
        Length inch1 = Length.createLength(3, LengthUnit.IN);
        Length inch2 = Length.createLength(5, LengthUnit.IN);


        assertEquals(Outcome.EQUAL,millimeter.compare(inch));
        assertEquals(Outcome.GREATER,millimeter.compare(inch1));
        assertEquals(Outcome.LESSER,millimeter.compare(inch2));
    }

    @Test
    void shouldAddTwoInches() throws UnitMismatchException, InvalidMeasurementValueException {
        Length inch = Length.createLength(4, LengthUnit.IN);
        Length inch1 = Length.createLength(3, LengthUnit.IN);
        Length expected = Length.createLength(7, LengthUnit.IN);

        assertEquals(expected,inch.add(inch1));
    }

    @Test
    void shouldAddInchAndCentimeter() throws UnitMismatchException, InvalidMeasurementValueException {
        Length inch = Length.createLength(2, LengthUnit.IN);
        Length centimeter = Length.createLength(2.5, LengthUnit.CM);
        Length expected = Length.createLength(3, LengthUnit.IN);

        assertEquals(expected,inch.add(centimeter));
    }
}