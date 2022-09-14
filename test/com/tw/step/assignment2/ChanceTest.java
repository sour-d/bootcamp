package com.tw.step.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

    @Test
    void shouldReturnChance() {
        Chance chanceOfTail = new Chance(0.5);
        assertEquals(0.5, chanceOfTail.getChance(), 0.1);
    }

    @Test
    void shouldReturnChanceOfOppositeEvent() {
        Chance chance = new Chance(0.6);
        Chance oppositeEventChance = new Chance(0.4);
        Chance expectedChance = chance.oppositeChance();

        assertEquals(oppositeEventChance, expectedChance);
    }

    @Test
    void shouldReturnChanceForTwoCoin() {
        Chance chance = new Chance(0.6);
        Chance anotherChance = new Chance(0.6);
        Chance chancesOfTwoEvents = chance.chanceOfTwoEvents(anotherChance);

        Chance expectedChance = new Chance(0.36);

        assertEquals(expectedChance, chancesOfTwoEvents);
    }

    @Test
    void chanceOfAtLeastOneTails() {
        Chance chance = new Chance(0.6);
        Chance anotherChance = new Chance(0.6);
        Chance chancesOfTwoEvents = chance.chanceOfAtLeastOneEvent(anotherChance);

        Chance expectedChance = new Chance(0.84);

        assertEquals(expectedChance, chancesOfTwoEvents);
    }
}