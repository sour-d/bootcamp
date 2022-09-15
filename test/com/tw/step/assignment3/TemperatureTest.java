package com.tw.step.assignment3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {
    @Test
    void shouldCompareTemperatures() {
        Temperature fahrenheit = Temperature.createTemperature(212,TemperatureUnit.F);
        Temperature celsius = Temperature.createTemperature(100,TemperatureUnit.C);
        Temperature celsius1 = Temperature.createTemperature(50,TemperatureUnit.C);
        Temperature celsius2 = Temperature.createTemperature(150,TemperatureUnit.C);

        assertEquals(Outcome.EQUAL,fahrenheit.compare(celsius));
        assertEquals(Outcome.GREATER,fahrenheit.compare(celsius1));
        assertEquals(Outcome.LESSER,fahrenheit.compare(celsius2));
    }
}