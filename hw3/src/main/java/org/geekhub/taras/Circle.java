package org.geekhub.taras;

public class Circle implements Shape {
    private final double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
            return (2 * Math.PI * radius);
    }

    @Override
    public double calculateArea() {
        return (Math.PI * Math.pow(radius, 2));
    }

}
