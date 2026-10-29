package prerequisities.OOP.abstraction.partialAbstraction;
/*
An abstract class is a class declared using the abstract keyword that cannot 
be instantiated directly. It can contain both abstract methods (without a body) and 
concrete methods (with a body), allowing it to provide common functionality while leaving some behavior to subclasses.

----> Can contain abstract and concrete methods.
----> Can have constructors, instance variables, and static members.
*/

// Declare an abstract class

abstract class vehicle {
    // Abstract method

    abstract void start(); // No body
}

// Concrete class

class Car extends vehicle {

    @Override

    void start() {
        System.out.println("Car strats with this key");
    }

}

public class abstract1 {

    public static void main(String[] args) {
        vehicle Vehicle = new Car();
        Vehicle.start();
    }

}
