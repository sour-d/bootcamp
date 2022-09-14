package com.tw.step.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {
    @Test
    void shouldReturnChanceOfOppositeEvent() {
        Chance chance = new Chance(0.6);
        Chance oppositeEventChance = new Chance(0.4);
        Chance expectedChance = chance.oppositeChance();

        assertEquals(oppositeEventChance, expectedChance);
    }

    @Test
    void shouldReturnChanceForTwoConsecutiveChances() {
        Chance chance = new Chance(0.6);
        Chance anotherChance = new Chance(0.6);
        Chance chancesOfTwoEvents = Chance.chanceOfTwoConsecutiveChances(chance, anotherChance);

        Chance expectedChance = new Chance(0.36);

        assertEquals(expectedChance, chancesOfTwoEvents);
    }

    @Test
    void chanceOfAtLeastOneChance() {
        Chance chance = new Chance(0.6);
        Chance anotherChance = new Chance(0.6);
        Chance chancesOfTwoEvents = Chance.chanceOfAtLeastChance(chance, anotherChance);

        Chance expectedChance = new Chance(0.84);

        assertEquals(expectedChance, chancesOfTwoEvents);
    }
}