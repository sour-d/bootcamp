package com.tw.step.assignment5;

import com.tw.step.assignment5.execption.BagLimitExceededException;
import com.tw.step.assignment5.execption.ForbiddenBallColorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void shouldAddBall() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(12);
        assertEquals(1, bag.addBall(new Ball(Color.GREEN)));
        assertEquals(2, bag.addBall(new Ball(Color.GREEN)));
    }

    @Test
    void shouldThrowExceptionIfBagLimitExceeded() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(1);
        bag.addBall(new Ball(Color.GREEN));

        assertThrows(BagLimitExceededException.class, () -> bag.addBall(new Ball(Color.GREEN)));
    }

    @Test
    void shouldThrowExceptionIfColorLimitExceed() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(12);
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.GREEN));
        assertThrows(ForbiddenBallColorException.class, () -> bag.addBall(new Ball(Color.GREEN)));
    }

    @Test
    void shouldNotAddRedBallIfBagIsEmpty() {
        Bag bag = new Bag(12);
        assertThrows(ForbiddenBallColorException.class, () -> bag.addBall(new Ball(Color.RED)));
    }

    @Test
    void shouldAddRedBallIfBagContainsGreen() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(12);
        bag.addBall(new Ball(Color.GREEN));
        assertEquals(2, bag.addBall(new Ball(Color.RED)));
    }

    @Test
    void shouldNotAddYellowBallIfBagIsEmpty() {
        Bag bag = new Bag(12);
        assertThrows(ForbiddenBallColorException.class, () -> bag.addBall(new Ball(Color.YELLOW)));
    }

    @Test
    void shouldAddYellowBallIfBagContainsTwoOtherColoredBalls() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(12);
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.RED));
        assertEquals(3, bag.addBall(new Ball(Color.YELLOW)));
    }

    @Test
    void shouldAddBlackBallIfBagIsEmpty() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(12);
        assertEquals(1, bag.addBall(new Ball(Color.BLACK)));
        assertEquals(2, bag.addBall(new Ball(Color.BLACK)));
    }

    @Test
    void shouldAddBlueBallIfBagIsEmpty() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(12);
        assertEquals(1, bag.addBall(new Ball(Color.BLUE)));
        assertEquals(2, bag.addBall(new Ball(Color.BLUE)));
    }

    @Test
    void shouldNotAddBlackBallIfBagContainsBlueBall() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(12);
        bag.addBall(new Ball(Color.BLUE));

        assertThrows(ForbiddenBallColorException.class, () -> bag.addBall(new Ball(Color.BLACK)));
    }

    @Test
    void shouldNotAddBlueBallIfBagContainsBlackBall() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(12);
        bag.addBall(new Ball(Color.BLACK));

        assertThrows(ForbiddenBallColorException.class, () -> bag.addBall(new Ball(Color.BLUE)));
    }
}