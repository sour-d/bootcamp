package com.tw.step.assignment5;

import java.util.List;

public enum BallColor {
    GREEN {
        private final int MAX_LIMIT = 3;

        @Override
        public boolean isColorAllowed(List<BallColor> existingBallColors) {
            long totalGreenBalls = this.ballCount(existingBallColors, BallColor.GREEN);
            return totalGreenBalls < MAX_LIMIT;
        }
    },
    RED {
        @Override
        public boolean isColorAllowed(List<BallColor> existingBallColors) {
            long totalGreenBalls = this.ballCount(existingBallColors, BallColor.GREEN);
            long totalRedBalls = this.ballCount(existingBallColors, BallColor.RED);

            return totalGreenBalls * 2 > totalRedBalls;
        }
    },
    YELLOW {
        private final double MAX_LIMIT = 40.0;
        @Override
        public boolean isColorAllowed(List<BallColor> existingBallColors) {
            long totalYellowBalls = this.ballCount(existingBallColors, BallColor.YELLOW);
            double percentageOfYellow = ((totalYellowBalls + 1) * 100.0) / (existingBallColors.size() + 1);
            return percentageOfYellow < MAX_LIMIT;
        }
    };


    public boolean isColorAllowed(List<BallColor> ballColors) {
        return false;
    }

    long ballCount(List<BallColor> ballColors, BallColor color) {
        return ballColors.stream()
                .filter(ballColor -> ballColor == color)
                .count();
    }
}
