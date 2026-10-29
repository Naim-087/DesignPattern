package prerequisities.OOP.abstraction.Interface;

interface Shape {
    double calculateArea();
}

// Implements the interface , in a class named circle

class Circle implements Shape {
    double r;

    Circle(double r) {
        this.r = r;
    }

    // Implementing the abstract method
    // from the Shape interface
    public double calculateArea() {
        return Math.PI * r * r;
    }
}

// Implement the interface in a
// class named Rectangle
class Rectangle implements Shape {

    private double length;
    private double width;

    // Constructor for Rectangle
    public Rectangle(double length, double width) {

        this.length = length;
        this.width = width;
    }

    // Implementing the abstract
    // method from the Shape interface
    public double calculateArea() {
        return length * width;
    }
}

public class Interface2 {
    public static void main(String[] args) {

        // Reference type is the interface (Shape)
        Shape cir = new Circle(5.0);
        Shape rect = new Rectangle(4.0, 6.0);

        // Dynamic method dispatch — decides which method to call at runtime
        System.out.println("Area of Circle: " + cir.calculateArea());
        System.out.println("Area of Rectangle: " + rect.calculateArea());
    }

}
