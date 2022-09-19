package com.tw.step.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void shouldAddBall() {
        Bag bag = new Bag();
        assertTrue(bag.addBall(new Ball()));
    }


}