package com.tw.step.assignment1;

import com.tw.step.assignment1.exception.NegativeHeightWidthException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void shouldCalculateArea() throws NegativeHeightWidthException {
        Rectangle rectangle1 = Rectangle.createRectangle(2, 3);
        assertEquals(6, rectangle1.area());

        Rectangle rectangle2 = Rectangle.createRectangle(2.2, 3.2);
        assertEquals(7.04, rectangle2.area(),0.1);
    }

    @Test
    void shouldCalculatePerimeter() throws NegativeHeightWidthException {
        Rectangle rectangle1 = Rectangle.createRectangle(2, 3);
        assertEquals(10, rectangle1.perimeter());

        Rectangle rectangle2 = Rectangle.createRectangle(2.2, 3.2);
        assertEquals(10.8, rectangle2.perimeter(), 0.1);
    }

    @Test
    void shouldThrowErrorIfOneOfTheArgumentIsNegative() {
        try {
            Rectangle.createRectangle(-1, 2);
        } catch (NegativeHeightWidthException e) {
            assertEquals(e.getMessage(), "Invalid argument -1.000000 or 2.000000");
        }
    }
}