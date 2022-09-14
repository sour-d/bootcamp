package com.tw.step.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {

    @Test
    void shouldReturnChanceOfTail() {
        Coin coin = new Coin(5, 5);
        assertEquals(0.5, coin.chanceOfOneTail(), 0.1);
    }

    @Test
    void shouldReturnChanceOfNotGettingTail() {
        Coin coin = new Coin(5, 5);
        assertEquals(0.5, coin.chanceOfNotGettingOneTail(), 0.1);
    }

    @Test
    void shouldReturnChanceForTwoCoin() {
        Coin coin = new Coin(5, 5);
        Coin coin1 = new Coin(5, 5);
        assertEquals(0.25, coin.chanceOfTwoTails(coin1), 0.1);
    }

    @Test
    void chanceOfAtLeastOneTails() {
        Coin coin = new Coin(5, 5);
        Coin coin1 = new Coin(5, 5);
        assertEquals(0.75, coin.chanceOfAtLeastOneTails(coin1), 0.1);
    }
}