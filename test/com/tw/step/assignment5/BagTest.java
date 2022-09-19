package com.tw.step.assignment5;

import com.tw.step.assignment5.execption.BagLimitExceededException;
import com.tw.step.assignment5.execption.ForbiddenBallColorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void shouldAddBall() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(12);
        assertEquals(1, bag.addBall(new Ball(BallColor.GREEN)));
        assertEquals(2, bag.addBall(new Ball(BallColor.GREEN)));
    }

    @Test
    void shouldThrowExceptionIfBagLimitExceeded() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(1);
        bag.addBall(new Ball(BallColor.GREEN));

        assertThrows(BagLimitExceededException.class, () -> bag.addBall(new Ball(BallColor.GREEN)));
    }

    @Test
    void shouldThrowExceptionIfColorLimitExceed() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(12);
        bag.addBall(new Ball(BallColor.GREEN));
        bag.addBall(new Ball(BallColor.GREEN));
        bag.addBall(new Ball(BallColor.GREEN));
        assertThrows(ForbiddenBallColorException.class, () -> bag.addBall(new Ball(BallColor.GREEN)));
    }

    @Test
    void shouldNotAddRedBallIfBagIsEmpty() {
        Bag bag = new Bag(12);
        assertThrows(ForbiddenBallColorException.class, () -> bag.addBall(new Ball(BallColor.RED)));
    }

    @Test
    void shouldAddRedBallIfBagContainsGreen() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(12);
        bag.addBall(new Ball(BallColor.GREEN));
//        assertThrows(ForbiddenBallColorException.class, () -> bag.addBall(new Ball(BallColor.RED)));
        assertEquals(2, bag.addBall(new Ball(BallColor.RED)));
    }
}