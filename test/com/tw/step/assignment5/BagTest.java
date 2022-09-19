package com.tw.step.assignment5;

import com.tw.step.assignment5.execption.BagLimitExceededException;
import com.tw.step.assignment5.execption.ColorLimitExceedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void shouldAddBall() throws ColorLimitExceedException, BagLimitExceededException {
        Bag bag = new Bag(12);
        assertEquals(1, bag.addBall(new Ball(Color.GREEN)));
    }

    @Test
    void shouldThrowExceptionIfBagLimitExceeded() throws ColorLimitExceedException, BagLimitExceededException {
        Bag bag = new Bag(1);
        bag.addBall(new Ball(Color.GREEN));

        assertThrows(BagLimitExceededException.class, () -> bag.addBall(new Ball(Color.GREEN)));
    }

    @Test
    void shouldThrowExceptionIfColorLimitExceed() throws ColorLimitExceedException, BagLimitExceededException {
        Bag bag = new Bag(12);
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.GREEN));
        assertThrows(ColorLimitExceedException.class, () -> bag.addBall(new Ball(Color.GREEN)));
    }
}