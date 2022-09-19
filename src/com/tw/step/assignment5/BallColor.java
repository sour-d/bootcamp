package com.tw.step.assignment5;

import java.util.List;

public enum BallColor {
    GREEN {
        private final int MAX_LIMIT = 3;

        @Override
        public boolean isColorAllowed(List<BallColor> existingColors) {
            long totalGreen = this.colorCount(existingColors, BallColor.GREEN);
            return totalGreen < MAX_LIMIT;
        }
    },
    RED {
        @Override
        public boolean isColorAllowed(List<BallColor> existingColors) {
            long totalGreen = this.colorCount(existingColors, BallColor.GREEN);
            long totalRed = this.colorCount(existingColors, BallColor.RED);

            return totalGreen * 2 > totalRed;
        }
    },
    YELLOW {
        private final double MAX_LIMIT = 40.0;

        @Override
        public boolean isColorAllowed(List<BallColor> existingColors) {
            long totalYellow = this.colorCount(existingColors, BallColor.YELLOW);
            double percentageOfYellow = ((totalYellow + 1) * 100.0) / (existingColors.size() + 1);
            return percentageOfYellow < MAX_LIMIT;
        }
    },
    BLUE {
        @Override
        public boolean isColorAllowed(List<BallColor> existingColors) {
            long totalBlack = this.colorCount(existingColors, BallColor.BLACK);
            return totalBlack < 1;
        }
    },
    BLACK{
        @Override
        public boolean isColorAllowed(List<BallColor> existingColors) {
            long totalBlue = this.colorCount(existingColors, BallColor.BLUE);
            return totalBlue < 1;
        }
    };

    public boolean isColorAllowed(List<BallColor> ballColors) {
        return false;
    }

    long colorCount(List<BallColor> ballColors, BallColor color) {
        return ballColors.stream()
                .filter(ballColor -> ballColor == color)
                .count();
    }
}
