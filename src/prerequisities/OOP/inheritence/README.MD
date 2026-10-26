Java OOP — Inheritance
A beginner-friendly and interview-focused guide to Inheritance in Java, with definitions, syntax, examples, constructor behavior, method overriding, real-world applications, and practice problems.
📚 Table of Contents
1. What Is Inheritance?
2. Why Do We Use Inheritance?
3. Basic Syntax
4. A Simple Example
5. Types of Inheritance in Java
6. extends and implements
7. The super Keyword
8. Constructor Execution in Inheritance
9. Method Overriding
10. Method Overloading vs Overriding
11. Access Modifiers and Inheritance
12. What Is Not Inherited?
13. Upcasting and Downcasting
14. The final Keyword and Inheritance
15. Real-World Example
16. Advantages and Disadvantages
17. Inheritance vs Composition
18. Inheritance and Design Principles
19. Common Mistakes
20. Interview Questions
21. Practice Problems
22. Quick Revision


📖 Recommended Learning Order
1. Classes and objects
2. Constructors
3. Inheritance
4. this and super
5. Method overriding
6. Runtime polymorphism
7. Abstract classes and interfaces
8. Encapsulation
9. Composition vs inheritance
10. SOLID principles
11. Design patterns
12. Dependency injection
Goal: Learn not only how inheritance works, but also when it creates a clear, maintainable design.




1. What Is Inheritance?
Interview Definition
Inheritance is an object-oriented programming mechanism in which a class acquires accessible fields and methods from another class. It helps organize related classes and supports code reuse and runtime polymorphism.
Simple Explanation
Think of a general Animal class. Different animals, such as dogs and cats, share common characteristics but can also have their own behaviors.

Instead of rewriting common behavior in every class, we can define it once in a parent class and extend it in child classes.
- Parent class / superclass / base class: The class being extended.
- Child class / subclass / derived class: The class that extends another class.
- extends: The Java keyword used by a class to inherit from another class.
Inheritance commonly models an IS-A relationship.

For example:
- A dog is an animal.
- A car is not an engine; a car has an engine. That relationship is usually better represented by composition.
2. Why Do We Use Inheritance?
- Code reuse: Share common behavior in a parent class.
- Extensibility: Add specialized behavior in child classes.
- Polymorphism: Use a parent type to refer to child objects.
- Maintainability: Keep shared behavior in one place when the relationship is appropriate.
- Clear hierarchy: Represent genuine IS-A relationships between types.
Use inheritance when the subclass is genuinely a specialized form of the superclass—not simply to avoid writing a few lines of code.

3. Basic Syntax
class Parent {
    void display() {
        System.out.println("Parent class");
    }
}

class Child extends Parent {
    void show() {
        System.out.println("Child class");
    }
}
Usage:
public class Main {
    public static void main(String[] args) {
        Child obj = new Child();

        obj.display(); // Inherited method
        obj.show();    // Child's own method
    }
}
Output:
Parent class
Child class
The Child class can use the accessible display() method inherited from Parent.
4. A Simple Example
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();

        dog.eat();
        dog.bark();
    }
}
Output:
Animal is eating
Dog is barking
What happens?
1. Animal defines the common eat() behavior.
2. Dog extends Animal, establishing an IS-A relationship.
3. A Dog object can call both the inherited eat() method and its own bark() method.
5. Types of Inheritance in Java
Java classes directly support single, multilevel, and hierarchical inheritance. Java does not support multiple inheritance of classes, but similar type combinations can be achieved through interfaces.
5.1 Single Inheritance
One child class extends one parent class.
class Animal {
    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking");
    }
}
Structure:
Animal
   |
  Dog
5.2 Multilevel Inheritance
A class extends a class that already extends another class.
class Animal {
    void eat() {
        System.out.println("Eating");
    }
}

class Mammal extends Animal {
    void walk() {
        System.out.println("Walking");
    }
}

class Dog extends Mammal {
    void bark() {
        System.out.println("Barking");
    }
}
Structure:
Animal
   |
 Mammal
   |
  Dog
A Dog object can access the accessible methods from all three levels.
5.3 Hierarchical Inheritance
Multiple child classes extend the same parent class.
class Animal {
    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("Meowing");
    }
}
Structure:
       Animal
       /    \
     Dog    Cat
Both Dog and Cat inherit the accessible behavior from Animal.
5.4 Multiple Inheritance Through Classes — Not Supported
Java does not allow a class to extend two classes:
// Invalid Java:
class C extends A, B {
}
One reason is that inheriting conflicting implementations can create ambiguity about which implementation should be used.
5.5 Multiple Inheritance Through Interfaces
Java allows a class to implement multiple interfaces.
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Duck can fly");
    }

    public void swim() {
        System.out.println("Duck can swim");
    }
}
Structure:
Flyable     Swimmable
    \         /
        Duck
A class can extend only one direct superclass, but it can implement multiple interfaces.
5.6 Hybrid Inheritance
Hybrid inheritance combines multiple inheritance structures. Java does not support every hybrid structure through classes alone, but combinations of class inheritance and interfaces can represent many such designs.
6. extends and implements
Keyword	Purpose	Example
extends	A class extends another class, or an interface extends another interface	class Dog extends Animal
implements	A class implements one or more interfaces	class Duck implements Flyable


Example:
interface Printable {
    void print();
}

class Document {
    void open() {
        System.out.println("Opening document");
    }
}

class Report extends Document implements Printable {
    public void print() {
        System.out.println("Printing report");
    }
}
A Report inherits accessible class behavior from Document and implements the contract declared by Printable.
7. The super Keyword
Interview Definition
The super keyword refers to the immediate superclass portion of the current object. It can be used to access superclass members and invoke a superclass constructor.
7.1 Access a Parent-Class Field
class Parent {
    String name = "Parent";
}

class Child extends Parent {
    String name = "Child";

    void display() {
        System.out.println(name);
        System.out.println(super.name);
    }
}
Output:
Child
Parent
Here, super.name explicitly refers to the superclass field.
7.2 Call a Parent-Class Method
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        super.sound();
        System.out.println("Dog barks");
    }
}
Output when new Dog().sound() is called:
Animal makes a sound
Dog barks
7.3 Call a Parent-Class Constructor
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

class Student extends Person {
    int studentId;

    Student(String name, int studentId) {
        super(name);
        this.studentId = studentId;
    }
}
super(name) invokes the superclass constructor that accepts a String.

Remember: In conventional Java constructor syntax, an explicit super(...) or this(...) invocation must be the first statement. Newer Java versions have more flexible constructor-body rules, but placing the invocation first remains widely compatible.
8. Constructor Execution in Inheritance
Interview Definition
When an object of a subclass is created, its superclass constructor chain runs before the subclass's own constructor body completes, so inherited state can be initialized first.

Example:
class Parent {
    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {
    Child() {
        System.out.println("Child constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        new Child();
    }
}
Output:
Parent constructor
Child constructor
Why Does the Parent Constructor Run First?
A child object includes the state defined by its parent class. The superclass construction step must happen before the subclass constructor finishes initializing the child-specific state.
Important Rules
- Constructors are not inherited.
- A subclass constructor must ultimately invoke a superclass constructor.
- If no constructor invocation is written, Java normally inserts an implicit no-argument superclass constructor invocation when permitted.
- If the superclass has no accessible no-argument constructor, the subclass must explicitly invoke an appropriate superclass constructor.
- this(...) can chain constructors within the same class; the chain eventually reaches a superclass constructor.
9. Method Overriding
Interview Definition
Method overriding occurs when a subclass provides its own implementation of an inherited instance method using a compatible method signature and return type. It enables runtime polymorphism.

Example:
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
Usage:
Animal animal = new Dog();
animal.sound();
Output:
Dog barks
Although the reference type is Animal, the object is a Dog. Java chooses the overridden instance method based on the actual object's runtime class.
Why Use @Override?
The @Override annotation tells the compiler that the method is intended to override an inherited method. It helps catch mistakes such as incorrect method names or signatures.
Rules of Method Overriding
- The method must be eligible for overriding.
- The overriding method cannot reduce the visibility of the inherited method.
- The return type must be the same or a permitted covariant subtype for reference types.
- A final method cannot be overridden.
- Static methods are hidden rather than overridden.
- Private methods are not overridden because they are not inherited as accessible subclass methods.
10. Method Overloading vs Overriding
Feature	Overloading	Overriding
Meaning	Same method name with different parameter lists	Subclass replaces inherited instance-method behavior
Inheritance required?	No	Yes, for ordinary subclass overriding
Parameters	Must differ	Must match the overridden signature
Polymorphism	Compile-time selection	Runtime dispatch for instance methods
Annotation	No special annotation required	@Override is recommended


Example of overloading:
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}
Example of overriding:
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow");
    }
}
11. Access Modifiers and Inheritance
Access modifiers control where class members can be accessed. Inheritance does not make every superclass member accessible everywhere.
Modifier	Same class	Same package	Subclass in another package	Unrelated class in another package
public	Yes	Yes	Yes	Yes
protected	Yes	Yes	Yes, subject to subclass access rules	No
Package-private (no modifier)	Yes	Yes	No, unless in the same package	No
private	Yes	No	No direct access	No


Important notes:
- Private superclass fields still form part of the superclass state, but subclasses cannot access them directly.
- A subclass may use public or protected superclass methods to work with private state.
- protected access across packages has specific rules: access is through inheritance in the subclass context, not unrestricted access through any superclass instance.
12. What Is Not Inherited?
Several Java features should not be described as inherited in the same way as accessible instance methods:
- Constructors: They are not inherited.
- Private members: They cannot be accessed directly by subclasses, though the superclass portion of an object still exists.
- Static methods: They can be accessible through a subclass name, but they are hidden rather than overridden.
- Private methods: They are not overridden by subclass methods.
A subclass can still invoke an accessible superclass constructor using super(...).
13. Upcasting and Downcasting
Upcasting
Definition: Upcasting converts a subclass reference to a superclass reference. It is generally safe and can be performed implicitly.
Dog dog = new Dog();
Animal animal = dog;
The animal reference can access the members declared as accessible through the Animal type, while overridden instance methods still use runtime dispatch.
Downcasting
Definition: Downcasting converts a superclass reference to a subclass reference. It requires an explicit cast and is safe only when the referenced object is compatible with the target type.
Animal animal = new Dog();

if (animal instanceof Dog) {
    Dog dog = (Dog) animal;
    dog.bark();
}
A cast to an incompatible subclass can throw ClassCastException.

Best practice: Prefer polymorphism over unnecessary downcasting.
14. The final Keyword and Inheritance
Final Class
A final class cannot be extended.
final class SecurityManager {
}

// Invalid:
// class CustomManager extends SecurityManager {}
Final Method
A final method cannot be overridden in a subclass.
class Parent {
    final void show() {
        System.out.println("Cannot override this method");
    }
}
Final Variable
A final variable can be assigned only once. For a reference variable, final prevents reassignment of the reference; it does not automatically make the referenced object immutable.
15. Real-World Example
Employee Management System
class Employee {
    private final String name;
    private final int employeeId;

    Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double calculateBonus() {
        return 0.0;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
    }
}

class FullTimeEmployee extends Employee {
    private final double monthlySalary;

    FullTimeEmployee(
            String name,
            int employeeId,
            double monthlySalary) {
        super(name, employeeId);

        if (monthlySalary < 0) {
            throw new IllegalArgumentException(
                "Salary cannot be negative"
            );
        }

        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    private final double hourlyRate;
    private final int hoursWorked;

    PartTimeEmployee(
            String name,
            int employeeId,
            double hourlyRate,
            int hoursWorked) {
        super(name, employeeId);

        if (hourlyRate < 0 || hoursWorked < 0) {
            throw new IllegalArgumentException(
                "Rate and hours must be non-negative"
            );
        }

        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateBonus() {
        return hourlyRate * hoursWorked * 0.05;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
            new FullTimeEmployee("Naim", 101, 50000),
            new PartTimeEmployee("Rahim", 102, 500, 40)
        };

        for (Employee employee : employees) {
            employee.displayDetails();
            System.out.println(
                "Bonus: " + employee.calculateBonus()
            );
            System.out.println();
        }
    }
}
Concepts Demonstrated
- Employee is the superclass.
- FullTimeEmployee and PartTimeEmployee are subclasses.
- super(...) initializes the shared employee state.
- @Override provides specialized bonus calculations.
- An Employee[] holds different employee subtypes.
- Runtime polymorphism calls the appropriate calculateBonus() implementation.
This example illustrates inheritance, encapsulation, constructor chaining, and polymorphism together.
16. Advantages and Disadvantages
Advantages
- Reduces duplicated code when classes share genuine behavior.
- Supports runtime polymorphism.
- Makes it easier to extend an existing hierarchy.
- Can model meaningful IS-A relationships.
Disadvantages
- Creates tighter coupling between parent and child classes.
- Changes to a superclass can affect multiple subclasses.
- Deep inheritance hierarchies can become difficult to understand.
- Incorrect inheritance can produce fragile or confusing designs.
- A subclass may inherit behavior that does not fit its responsibilities.
17. Inheritance vs Composition
Inheritance
Represents an IS-A relationship.
class Dog extends Animal {
}
A dog is an animal.
Composition
Represents a HAS-A relationship.
class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Car {
    private final Engine engine = new Engine();

    void startCar() {
        engine.start();
    }
}
A car has an engine.
Inheritance	Composition
Extends a type	Contains or delegates to another object
Models IS-A	Models HAS-A
Often creates tighter coupling	Often provides more flexibility
Useful for genuine subtype relationships	Useful for assembling behavior from components


Design tip: Favor composition over inheritance when a HAS-A relationship better describes the problem. Inheritance is still valuable when a true subtype relationship exists.
18. Inheritance and Design Principles
Liskov Substitution Principle (LSP)
Interview definition: Objects of a subtype should be usable wherever objects of the base type are expected without breaking the correctness of the program.

In practical terms, a subclass should preserve the expectations and behavioral contract of its superclass.
Open/Closed Principle (OCP)
Interview definition: Software entities should be open for extension but closed for modification.

Polymorphism and well-designed abstractions can let you add new implementations without repeatedly changing existing client logic.
Dependency Inversion Principle (DIP)
Interview definition: High-level modules should depend on abstractions rather than concrete implementations.

Inheritance alone does not guarantee good design. Interfaces and dependency injection can help separate code from specific implementations.
Design Patterns Related to Inheritance
- Template Method: A superclass defines an algorithm's structure while subclasses implement selected steps.
- Factory Method: A creator type defines a creation method that subclasses can specialize.
- Strategy: Often uses composition and interfaces instead of a deep inheritance hierarchy.
19. Common Mistakes
1. Confusing extends and implements: Classes extend classes and implement interfaces.
2. Trying to extend multiple classes: Java classes can have only one direct superclass.
3. Forgetting super(...): A subclass may need to explicitly call a superclass constructor when no accessible no-argument constructor exists.
4. Reducing method visibility during overriding: An overriding method cannot be less accessible than the overridden method.
5. Calling static method hiding overriding: Static methods are hidden, not dynamically overridden.
6. Assuming private fields are directly accessible: Use appropriate superclass methods to access encapsulated state.
7. Using inheritance only for code reuse: Check whether the relationship truly represents IS-A.
8. Downcasting without checking: An incompatible cast can throw ClassCastException.
9. Forgetting @Override: The annotation helps catch accidental signature mistakes.
10. Creating deep hierarchies unnecessarily: Prefer a clear, shallow design when possible.
20. Interview Questions
Beginner Level
Q1. What is inheritance in Java?

Inheritance is an OOP mechanism through which a class acquires accessible members from a superclass. It supports code reuse, specialization, and polymorphism.

Q2. What is a superclass?

A superclass is a class that another class extends.

Q3. What is a subclass?

A subclass is a class that extends another class.

Q4. Which keyword is used for class inheritance?

extends.

Q5. Does Java support multiple inheritance?

Java does not support extending multiple classes, but a class can implement multiple interfaces.
Intermediate Level
Q6. What is the difference between this and super?

this refers to the current object, while super is used to access superclass members or invoke a superclass constructor.

Q7. Are constructors inherited?

No. A subclass defines its own constructors and can invoke a superclass constructor.

Q8. Can private members be inherited?

Private superclass state is part of the object, but private members are not directly accessible in a subclass. They cannot be overridden as accessible methods.

Q9. What is method overriding?

It is when a subclass provides a compatible implementation of an inherited instance method.

Q10. Why use @Override?

It asks the compiler to verify that the method really overrides an inherited method.

Q11. Can static methods be overridden?

No. Static methods are hidden, not overridden.

Q12. Can a final class be inherited?

No. A final class cannot be extended.

Q13. What is constructor chaining?

It is the process of one constructor invoking another constructor in the same class or in its superclass.
Advanced Level
Q14. What is runtime polymorphism?

It is the selection of an overridden instance-method implementation based on the actual object's runtime class.

Q15. What is upcasting?

Treating a subclass object through a superclass reference.

Q16. What is downcasting?

Converting a superclass reference to a subclass reference when the object is compatible with that subclass.

Q17. What is the Liskov Substitution Principle?

A subtype should be usable wherever its base type is expected without violating correctness or expected behavior.

Q18. Why might composition be preferred over inheritance?

Composition can reduce coupling and allow behavior to be changed by replacing or combining components without creating a large inheritance hierarchy.

Q19. What is the diamond problem?

It is an ambiguity that can occur when a type inherits the same member through multiple paths. Java avoids multiple class inheritance, and interface default-method conflicts have specific resolution rules.

Q20. Does inheritance automatically provide encapsulation?

No. Encapsulation depends on access control and how state is exposed. Inheritance and encapsulation are separate OOP concepts.
21. Practice Problems
Beginner
- [ ] Create an Animal superclass with an eat() method.
- [ ] Create Dog and Cat subclasses.
- [ ] Demonstrate single inheritance.
- [ ] Demonstrate hierarchical inheritance.
- [ ] Explain the difference between a superclass and a subclass.
Intermediate
- [ ] Create Person, Student, and GraduateStudent classes to demonstrate multilevel inheritance.
- [ ] Use super(...) to initialize parent fields.
- [ ] Override a method and use @Override.
- [ ] Demonstrate runtime polymorphism with a superclass reference.
- [ ] Experiment with public, protected, package-private, and private members.
Advanced
- [ ] Build an employee hierarchy with different bonus calculations.
- [ ] Design a notification system using an interface and multiple implementations.
- [ ] Explain how the Liskov Substitution Principle applies to a class hierarchy.
- [ ] Refactor an inappropriate inheritance example into composition.
- [ ] Implement a Template Method example and explain the role of inheritance.
22. Quick Revision
Concept	One-line definition
Inheritance	Acquiring accessible members from a superclass
Superclass	The class being extended
Subclass	The class that extends another class
extends	Keyword for class inheritance or interface extension
implements	Keyword for implementing interfaces
Single inheritance	One subclass extends one superclass
Multilevel inheritance	Inheritance across multiple levels
Hierarchical inheritance	Multiple subclasses share a superclass
super	Accesses superclass members or invokes a superclass constructor
Method overriding	Subclass provides a compatible implementation of an inherited instance method
Runtime polymorphism	Overridden method behavior is selected using the runtime object type
Upcasting	Using a subclass object through a superclass reference
Downcasting	Casting a superclass reference to a compatible subclass type
Composition	Building a class using other objects
LSP	Subtypes must preserve the behavioral expectations of their base types


Final Interview Answer
What is inheritance in Java?

Inheritance is an object-oriented programming mechanism that allows a class to acquire accessible fields and methods from another class. The existing class is called the superclass, and the class that extends it is called the subclass. Java uses the extends keyword for class inheritance. Inheritance supports code reuse, specialization, and runtime polymorphism. Java supports single, multilevel, and hierarchical inheritance through classes, while multiple inheritance of classes is not supported; a class can implement multiple interfaces.
