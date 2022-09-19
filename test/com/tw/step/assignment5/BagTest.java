package com.tw.step.assignment5;

import com.tw.step.assignment5.Execption.ColorLimitExceedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void shouldAddBall() throws ColorLimitExceedException {
        Bag bag = new Bag();
        assertEquals(1, bag.addBall(new Ball(Color.GREEN)));
    }

    @Test
    void shouldThrowExceptionIfColorLimitExceed() throws ColorLimitExceedException {
        Bag bag = new Bag();
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.GREEN));
        assertThrows(ColorLimitExceedException.class, () -> bag.addBall(new Ball(Color.GREEN)));
    }
}