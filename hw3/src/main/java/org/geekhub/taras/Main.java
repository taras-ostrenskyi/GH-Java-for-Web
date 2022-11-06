package org.geekhub.taras;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Please enter a shape name (circle, square, rectangle, triangle)");
        Scanner scan = new Scanner(System.in);
        Printer printerMain = new Printer();
        String shapeName = scan.nextLine();
        boolean isEnum = false;

        for (ShapeType type : ShapeType.values()){
            if (type.name().equalsIgnoreCase(shapeName))
            {
                isEnum = true;
                shapeName = shapeName.toLowerCase();
                break;
            }
        }

        if (isEnum){
            switch (shapeName){
                case ("circle"):
                    System.out.println("Please enter the length of the radius");
                    String radiusStr = scan.nextLine();
                    double radius = Double.parseDouble(radiusStr);
                    if (radius > 0) {
                        Circle circleMain = new Circle(radius);
                        printerMain.printPerimeterArea(circleMain);
                    }
                    else {
                        System.out.println("Invalid radius values entered");
                    }
                    break;
                case ("square"):
                    System.out.println("Please enter the length of the side of the square");
                    String sideLengthSquareStr = scan.nextLine();
                    double sideLengthSquare = Double.parseDouble(sideLengthSquareStr);
                    if (sideLengthSquare > 0) {
                        Square squareMain = new Square(sideLengthSquare);
                        printerMain.printPerimeterArea(squareMain);
                        System.out.println();
                        System.out.println("This square consists of two triangles");
                        Triangle triangleInSquare = new Triangle(sideLengthSquare, sideLengthSquare);
                        printerMain.printPerimeterArea(triangleInSquare);
                    }
                    else {
                        System.out.println("Invalid side length values entered");
                    }
                    break;
                case ("rectangle"):
                    System.out.println("Please enter the length of the side a of rectangle");
                    String sideArectangleStr = scan.nextLine();
                    double sideArectangle = Double.parseDouble(sideArectangleStr);
                    System.out.println("Please enter the length of the side b of rectangle");
                    String sideBrectangleStr = scan.nextLine();
                    double sideBrectangle = Double.parseDouble(sideBrectangleStr);
                    if (sideArectangle > 0 && sideBrectangle > 0) {
                        Rectangle rectangleMain = new Rectangle(sideArectangle, sideBrectangle);
                        printerMain.printPerimeterArea(rectangleMain);
                        System.out.println();
                        System.out.println("This rectangle consists of two triangles");
                        Triangle triangleInRect = new Triangle(sideArectangle, sideBrectangle);
                        printerMain.printPerimeterArea(triangleInRect);
                    }
                    else{
                        System.out.println("Invalid side length values entered");
                    }
                    break;
                case ("triangle"):
                    System.out.println("Please enter the length of the side a of triangle");
                    String sideAtriangleStr = scan.nextLine();
                    double sideAtriangle = Double.parseDouble(sideAtriangleStr);
                    System.out.println("Please enter the length of the side b of triangle");
                    String sideBtriangleStr = scan.nextLine();
                    double sideBtriangle = Double.parseDouble(sideBtriangleStr);
                    System.out.println("Please enter the length of the side c of triangle");
                    String sideCtriangleStr = scan.nextLine();
                    double sideCtriangle = Double.parseDouble(sideCtriangleStr);
                    if (sideAtriangle + sideBtriangle > sideCtriangle
                            && sideAtriangle + sideCtriangle > sideBtriangle
                            && sideBtriangle + sideCtriangle > sideAtriangle
                            && sideAtriangle > 0 && sideBtriangle > 0 && sideCtriangle > 0){
                        Triangle triangleMain = new Triangle(sideAtriangle, sideBtriangle, sideCtriangle);
                        printerMain.printPerimeterArea(triangleMain);
                    }
                    else{
                        System.out.println("Invalid side length values entered, or triangle with such sides does not exist");
                    }
                    break;
                default:
                    System.out.println("Invalid shape name entered");
            }
        }
        else{
            System.out.println("Invalid shape name entered");
        }
    }
}