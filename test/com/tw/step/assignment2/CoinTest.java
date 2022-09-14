package com.tw.step.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {

    @Test
    void shouldReturnChanceOfTail() {
        Coin coin = new Coin(5, 5);
        assertEquals(0.5, coin.possibilityOfTail(), 0.1);
    }

    @Test
    void shouldReturnChanceOfNotGettingTail() {
        Coin coin = new Coin(5, 5);
        assertEquals(0.5, coin.possibilityOfNotGettingTail(), 0.1);
    }

    @Test
    void shouldReturnChanceForTwoCoin() {
        Coin coin = new Coin(5, 5);
        Coin coin1 = new Coin(5, 5);
        assertEquals(0.25, coin.possibilityOfTailWithOtherCoin(coin1), 0.1);
    }
}