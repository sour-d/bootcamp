package com.tw.step.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {
    @Test
    void shouldCompareGallonAndLitre() {
        Volume gallon = new Volume(1, VolumeUnit.GALLON);
        Volume liter = new Volume(3.78, VolumeUnit.LITER);
        Volume liter1 = new Volume(3, VolumeUnit.LITER);
        Volume liter2 = new Volume(4, VolumeUnit.LITER);

        assertEquals(Outcome.EQUAL, gallon.compare(liter));
        assertEquals(Outcome.GREATER, gallon.compare(liter1));
        assertEquals(Outcome.LESSER, gallon.compare(liter2));
    }
}