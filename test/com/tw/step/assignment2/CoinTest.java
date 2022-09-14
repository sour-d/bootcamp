package com.tw.step.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {

    @Test
    void possibilityOfTail() {
        assertEquals(0.5, Coin.possibilityOfTail(), 0.1);
    }
}