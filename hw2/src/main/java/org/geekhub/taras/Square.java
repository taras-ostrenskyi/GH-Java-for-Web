package org.geekhub.taras;

public class Square extends Shape {
    double side;

    public Square(double side){
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return Math.pow(side, 2);
    }

    @Override
    public double calculatePerimeter() {
        return (4 * side);
    }
}
