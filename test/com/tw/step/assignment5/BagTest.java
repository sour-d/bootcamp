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
        assertEquals(2, bag.addBall(new Ball(BallColor.RED)));
    }

    @Test
    void shouldNotAddYellowBallIfBagIsEmpty() {
        Bag bag = new Bag(12);
        assertThrows(ForbiddenBallColorException.class, () -> bag.addBall(new Ball(BallColor.YELLOW)));
    }

    @Test
    void shouldAddYellowBallIfBagContainsTwoOtherColoredBalls() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(12);
        bag.addBall(new Ball(BallColor.GREEN));
        bag.addBall(new Ball(BallColor.RED));
        assertEquals(3, bag.addBall(new Ball(BallColor.YELLOW)));
    }

    @Test
    void shouldAddBlackBallIfBagIsEmpty() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(12);
        assertEquals(1, bag.addBall(new Ball(BallColor.BLACK)));
        assertEquals(2, bag.addBall(new Ball(BallColor.BLACK)));
    }

    @Test
    void shouldAddBlueBallIfBagIsEmpty() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(12);
        assertEquals(1, bag.addBall(new Ball(BallColor.BLUE)));
        assertEquals(2, bag.addBall(new Ball(BallColor.BLUE)));
    }

    @Test
    void shouldNotAddBlackBallIfBagContainsBlueBall() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(12);
        bag.addBall(new Ball(BallColor.BLUE));

        assertThrows(ForbiddenBallColorException.class, () -> bag.addBall(new Ball(BallColor.BLACK)));
    }

    @Test
    void shouldNotAddBlueBallIfBagContainsBlackBall() throws ForbiddenBallColorException, BagLimitExceededException {
        Bag bag = new Bag(12);
        bag.addBall(new Ball(BallColor.BLACK));

        assertThrows(ForbiddenBallColorException.class, () -> bag.addBall(new Ball(BallColor.BLUE)));
    }
}