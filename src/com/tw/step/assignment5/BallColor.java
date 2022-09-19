package com.tw.step.assignment5;

import java.util.List;

public enum BallColor {
    GREEN {
        private final int MAX_LIMIT = 3;
        @Override
        public boolean isColorAllowed(List<BallColor> ballColors) {
            long totalGreenBalls = ballColors.stream()
                    .filter(color -> color == BallColor.GREEN)
                    .count();

            return totalGreenBalls < MAX_LIMIT;
        }
    },
    RED {
        @Override
        public boolean isColorAllowed(List<BallColor> ballColors) {
            long totalGreenBalls = this.ballCount(ballColors, BallColor.GREEN);
            long totalRedBalls = this.ballCount(ballColors, BallColor.RED);

            return totalGreenBalls * 2 > totalRedBalls;
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
