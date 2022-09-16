package com.tw.step.assignment3;

import com.tw.step.assignment3.exception.InvalidMeasurementValueException;
import com.tw.step.assignment3.unit.LengthUnit;
import com.tw.step.assignment3.unit.VolumeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {
    @Test
    void shouldThrowExceptionForInvalidLength() {
        assertThrows(InvalidMeasurementValueException.class, () -> Volume.createVolume(-1, VolumeUnit.GALLON));
    }

    @Test
    void shouldCompareGallonAndLitre() throws InvalidMeasurementValueException {
        Volume gallon = Volume.createVolume(1, VolumeUnit.GALLON);
        Volume liter = Volume.createVolume(3.8, VolumeUnit.LITER);
        Volume liter1 = Volume.createVolume(3, VolumeUnit.LITER);
        Volume liter2 = Volume.createVolume(4, VolumeUnit.LITER);

        assertEquals(Outcome.EQUAL, gallon.compare(liter));
        assertEquals(Outcome.GREATER, gallon.compare(liter1));
        assertEquals(Outcome.LESSER, gallon.compare(liter2));
    }

    @Test
    void shouldAddTwoVolumes() throws InvalidMeasurementValueException {
        Volume gallon = Volume.createVolume(1, VolumeUnit.GALLON);
        Volume liter = Volume.createVolume(1, VolumeUnit.LITER);
        Volume expected = Volume.createVolume(4.8, VolumeUnit.LITER);

        assertEquals(expected, gallon.add(liter));
    }
}