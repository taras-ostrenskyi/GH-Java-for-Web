package org.geekhub.taras;

public class Rectangle extends Shape {

    double sideA;
    double sideB;

    public Rectangle(double sideA, double sideB){
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double calculateArea() {
        return sideA * sideB;
    }

    @Override
    public double calculatePerimeter() {
        return (2 * sideA + 2 * sideB);
    }
}
