package org.geekhub.taras;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Please enter a shape name (circle, square, rectangle, triangle)");
        Scanner scan = new Scanner(System.in);
        String shapeName = scan.nextLine();

        switch (shapeName){
            case ("circle"):
                System.out.println("Please enter the length of the radius");
                double radius = Double.parseDouble(scan.nextLine());
                if (radius > 0) {
                    Circle circleMain = new Circle(radius);
                    System.out.println("The length of the circle is: " + circleMain.calculatePerimeter());
                    System.out.println("The area of the circle is: " + circleMain.calculateArea());
                }
                else {
                    System.out.println("Invalid radius values entered");
                }
                break;
            case ("square"):
                System.out.println("Please enter the length of the side of the square");
                double sideSquare = Double.parseDouble(scan.nextLine());
                if (sideSquare > 0) {
                    Square squareMain = new Square(sideSquare);
                    System.out.println("The perimeter of the square is: " + squareMain.calculatePerimeter());
                    System.out.println("The area of the square is: " + squareMain.calculateArea());
                    System.out.println();
                    System.out.println("This square consists of two triangles");
                    Triangle triangleInSquare = new Triangle(sideSquare, sideSquare);
                    System.out.println("The perimeter of the triangle is: " + triangleInSquare.calculatePerimeter());
                    System.out.println("The area of the triangle is: " + triangleInSquare.calculateArea());
                }
                else {
                    System.out.println("Invalid side length values entered");
                }
                break;
            case ("rectangle"):
                System.out.println("Please enter the length of the side a of rectangle");
                double sideArectangle = Double.parseDouble(scan.nextLine());
                System.out.println("Please enter the length of the side b of rectangle");
                double sideBrectangle = Double.parseDouble(scan.nextLine());
                if (sideArectangle > 0 && sideBrectangle > 0) {
                    Rectangle rectangleMain = new Rectangle(sideArectangle, sideBrectangle);
                    System.out.println("The perimeter of the rectangle is: " + rectangleMain.calculatePerimeter());
                    System.out.println("The area of the rectangle is: " + rectangleMain.calculateArea());
                    System.out.println();
                    System.out.println("This rectangle consists of two triangles");
                    Triangle triangleInRectangle = new Triangle(sideArectangle, sideBrectangle);
                    System.out.println("The perimeter of the triangle is: " + triangleInRectangle.calculatePerimeter());
                    System.out.println("The area of the triangle is: " + triangleInRectangle.calculateArea());
                }
                else{
                    System.out.println("Invalid side length values entered");
                }
                break;
            case ("triangle"):
                System.out.println("Please enter the length of the side a of triangle");
                double sideAtriangle = Double.parseDouble(scan.nextLine());
                System.out.println("Please enter the length of the side b of triangle");
                double sideBtriangle = Double.parseDouble(scan.nextLine());
                System.out.println("Please enter the length of the side c of triangle");
                double sideCtriangle = Double.parseDouble(scan.nextLine());
                if (sideAtriangle + sideBtriangle > sideCtriangle
                        && sideAtriangle + sideCtriangle > sideBtriangle
                        && sideBtriangle + sideCtriangle > sideAtriangle
                        && sideAtriangle > 0 && sideBtriangle > 0 && sideCtriangle > 0){
                    Triangle triangleMain = new Triangle(sideAtriangle, sideBtriangle, sideCtriangle);
                    System.out.println("The perimeter of the triangle is: " + triangleMain.calculatePerimeter());
                    System.out.println("The area of the triangle is: " + triangleMain.calculateArea());
                }
                else{
                    System.out.println("Invalid side length values entered, or triangle with such sides does not exist");
                }
                break;
            default:
                System.out.println("Invalid shape name entered");
        }

    }
}