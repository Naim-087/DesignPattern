package prerequisities.OOP.abstraction.partialAbstraction;

/*
+----------------------------------+
               |      Shape (Abstract class)      |
               +----------------------------------+
               | color: String                    |
               | abstract area(): double          |
               | abstract toString(): String      |
               | getColor(): String               |
               +----------------------------------+
                                ^
                                |
               +----------------+----------------+
       extends |                                 | extends
+-------------------------+           +----------------------------+
|  Circle (concrete class)|           |  Rectangle (concrete class)|
+-------------------------+           +----------------------------+
| radius: double          |           | length: double             |
|                         |           | width: double              |
+-------------------------+           +----------------------------+


*/

abstract class Shape {

    String color;

    abstract double area();

    public abstract String toString();

    Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}

// Concrete Class
class Circle extends Shape {

    double radius;

    Circle(String color, double radius) // Constructor
    {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle color is " + super.getColor() + "and area is : " + area();
    }
}

// Concrete Class
class Rectangle extends Shape {

    double length;
    double width;

    Rectangle(String color, double length, double width) {

        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override

    public String toString() {
        return "Rectangle color is : " + super.getColor() + "and areas is :" + area();
    }

}

public class abstract2 {
    public static void main(String[] args) {
        Shape s1 = new Circle("Blue", 3.3);
        Shape s2 = new Rectangle("Red", 4.1, 2.3);

        System.out.println(s1.toString());

        System.out.println(s2.toString());
    }
}