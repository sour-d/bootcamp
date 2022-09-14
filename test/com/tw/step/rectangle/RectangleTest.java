package com.tw.step.rectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void shouldCalculateAreaIfValuesAreInteger() {
        Rectangle rectangle = new Rectangle(2, 3);
        assertEquals(rectangle.area(), 6);
    }

    @Test
    void shouldCalculateAreaIfValuesAreDouble() {
        Rectangle rectangle = new Rectangle(2.2, 3.2);
        assertEquals(rectangle.area(), 7.04,0.1);
    }

    @Test
    void shouldCalculatePerimeterIfValuesAreInteger() {
        Rectangle rectangle = new Rectangle(2, 3);
        assertEquals(rectangle.perimeter(), 10);
    }

    @Test
    void shouldCalculatePerimeterIfValuesAreDouble() {
        Rectangle rectangle = new Rectangle(2.2, 3.2);
        assertEquals(rectangle.perimeter(), 10.8, 0.1);
    }
}