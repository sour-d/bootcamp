package com.tw.step.assignment2;

import com.tw.step.assignment2.exception.InvalidChanceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {
    @Test
    void shouldReturnChanceForComplement() throws InvalidChanceException {
        Chance gettingSix = Chance.createChance(0.166);
        Chance gettingNotSix = gettingSix.complement();

        Chance expected = Chance.createChance(0.833);

        assertTrue(expected.isApprox(gettingNotSix,0.01));
    }

    @Test
    void shouldReturnChanceForTwoConsecutiveChances() throws InvalidChanceException {
        Chance chanceOfSix = Chance.createChance(0.166);
        Chance consecutiveSixes = chanceOfSix.and(chanceOfSix);

        Chance expected = Chance.createChance(0.02755);

        assertTrue(expected.isApprox(consecutiveSixes,0.001));
    }

    @Test
    void chanceOfAtLeastOneChance() throws InvalidChanceException {
        Chance chanceOfSix = Chance.createChance(0.166);
        Chance atLeastOneSix = chanceOfSix.or(chanceOfSix);

        Chance expected = Chance.createChance(0.304);

        assertTrue(expected.isApprox(atLeastOneSix, 0.01));
    }

    @Test
    void shouldThrowErrorIfChanceIsGreaterThanOne() {
        assertThrows(InvalidChanceException.class, () -> Chance.createChance(2));
    }

    @Test
    void shouldThrowErrorIfChanceIsLessThanZero() {
        assertThrows(InvalidChanceException.class, () -> Chance.createChance(-1));
    }
}