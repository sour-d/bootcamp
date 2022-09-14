package com.tw.step.rectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void shouldCalculateAreaOfSquare() {
        Square square = new Square(4);
        assertEquals(square.area(), 16);
    }

    @Test
    void shouldCalculatePerimeterOfSquare() {
        Square square = new Square(2);
        assertEquals(square.perimeter(),8);

    }
}