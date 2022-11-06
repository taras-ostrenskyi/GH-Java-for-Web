package org.geekhub.taras;

public class Printer {

    public Printer(){
    }

    public void printPerimeterArea(Shape shapeType) {
        System.out.println("The perimeter of this shape is: " + shapeType.calculatePerimeter());
        System.out.println("The area of this shape is: " + shapeType.calculateArea());
    }
}


