package org.geekhub.taras;

public class Square implements Shape {
    private final double side;

    public Square(double side){
        this.side = side;
    }

    @Override
    public double calculatePerimeter() {
        return (4 * side);
    }

    @Override
    public double calculateArea() {
        return Math.pow(side, 2);
    }

}
