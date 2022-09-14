package com.tw.step.assignment1;

import com.tw.step.assignment1.exception.NegativeHeightWidthException;
import com.tw.step.assignment1.exception.NegativeSideException;

class Rectangle {
    private final double height;
    private final double width;

    private Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public static Rectangle createRectangle(double height, double width) throws NegativeHeightWidthException {
        if(height <= 0 || width <= 0) {
            throw new NegativeHeightWidthException(height, width);
        }
        return new Rectangle(height, width);
    }

    public static Rectangle createSquare(double side) throws NegativeSideException {
        if(side <= 0) {
            throw new NegativeSideException(side);
        }
        return new Rectangle(side, side);
    }

    public double area(){
        return this.height * this.width;
    }

    public double perimeter(){
        return 2*(this.height + this.width);
    }
}
