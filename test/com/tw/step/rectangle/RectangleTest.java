package com.tw.step.rectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void area() {
        Rectangle rectangle = new Rectangle(2, 3);
        assertEquals(rectangle.area(), 6);
    }

    @Test
    void perimeter() {
        Rectangle rectangle = new Rectangle(2, 3);
        assertEquals(rectangle.perimeter(), 10);
    }
}