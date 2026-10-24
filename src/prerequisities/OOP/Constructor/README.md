# Java OOP — Constructors

A beginner-friendly guide to Java constructors, object initialization, constructor overloading, `this()`, `super()`, interview definitions, and design pattern fundamentals.

## 📚 Table of Contents

1. [What Is a Constructor?](#1-what-is-a-constructor)
2. [Constructor Syntax](#2-constructor-syntax)
3. [Rules of Constructors](#3-rules-of-constructors)
4. [Types of Constructors](#4-types-of-constructors)
5. [Default vs No-Argument Constructor](#5-default-vs-no-argument-constructor)
6. [Parameterized Constructor](#6-parameterized-constructor)
7. [The `this` Keyword](#7-the-this-keyword)
8. [Constructor Overloading](#8-constructor-overloading)
9. [Constructor Chaining Using `this()`](#9-constructor-chaining-using-this)
10. [Constructor and `super()`](#10-constructor-and-super)
11. [Constructor vs Method](#11-constructor-vs-method)
12. [Access Modifiers in Constructors](#12-access-modifiers-in-constructors)
13. [Private Constructors](#13-private-constructors)
14. [Constructor Best Practices](#14-constructor-best-practices)
15. [Real-World Example](#15-real-world-example)
16. [Constructor Interview Questions](#16-constructor-interview-questions)
17. [Connection to Design Patterns](#17-connection-to-design-patterns)
18. [Practice Problems](#18-practice-problems)
19. [Quick Revision](#19-quick-revision)

---

## 1. What Is a Constructor?

### Interview Definition

A **constructor in Java is a special class member used to initialize an object when it is created.** It has the same name as its class and does not have a return type.

### Simple Explanation

A constructor provides the initial state of an object.

For example, when creating a bank account, we may want to initialize the account holder's name, account number, and initial balance.

```java
class BankAccount {

    String accountHolder;
    double balance;

    BankAccount(String name, double initialBalance) {
        accountHolder = name;
        balance = initialBalance;
    }
}
```

Creating an object:

```java
BankAccount account = new BankAccount("Naim", 5000);
```

The constructor initializes the newly created object's fields.

### Why Do We Need Constructors?

- To initialize object fields.
- To provide meaningful initial values.
- To ensure an object starts in a valid state.
- To enforce initialization requirements.
- To make object creation easier and more consistent.

---

## 2. Constructor Syntax

```java
class ClassName {

    ClassName() {
        // Initialization logic
    }
}
```

Example:

```java
class Student {

    String name;

    Student() {
        name = "Unknown";
    }
}
```

Usage:

```java
Student student = new Student();

System.out.println(student.name);
```

Output:

```text
Unknown
```

### Understanding the Syntax

- `Student` — the constructor name.
- `Student()` — the constructor declaration with no parameters.
- `new Student()` — creates an object and invokes the constructor.
- `name = "Unknown"` — initializes the instance variable.

---

## 3. Rules of Constructors

1. A constructor must have the same name as its class.
2. A constructor cannot declare a return type, including `void`.
3. Constructors are invoked during object creation.
4. Constructors can accept zero or more parameters.
5. Constructors can be overloaded.
6. Constructors are not inherited by subclasses.
7. Constructors cannot be overridden.
8. If no constructor is declared, the compiler provides a default constructor.
9. If any constructor is explicitly declared, the compiler does not automatically provide the default constructor.
10. A constructor can have access modifiers such as `public`, `protected`, package-private, or `private`.

**Important:** Constructors are not ordinary methods, although they can contain executable statements.

---

## 4. Types of Constructors

For beginner-level Java, the main categories are:

### 4.1 Default Constructor

**Interview definition:** A default constructor is the no-argument constructor implicitly provided by the Java compiler when a class declares no constructor.

Example:

```java
class Student {
    String name;
    int age;
}
```

Usage:

```java
Student s1 = new Student();

System.out.println(s1.name);
System.out.println(s1.age);
```

Output:

```text
null
0
```

The compiler-generated constructor leaves the instance fields at their Java default values.

Common default values:

| Data type | Default value |
|---|---|
| `int` | `0` |
| `double` | `0.0` |
| `boolean` | `false` |
| `char` | `'\u0000'` |
| Reference types | `null` |

Note: Local variables do not automatically receive these default values.

### 4.2 No-Argument Constructor

**Interview definition:** A no-argument constructor is a constructor explicitly declared without parameters.

Example:

```java
class Student {

    String name;
    int age;

    Student() {
        name = "Unknown";
        age = 18;
    }
}
```

Usage:

```java
Student s1 = new Student();

System.out.println(s1.name);
System.out.println(s1.age);
```

Output:

```text
Unknown
18
```

Unlike the compiler-generated default constructor, a programmer-written no-argument constructor can perform custom initialization.

### 4.3 Parameterized Constructor

**Interview definition:** A parameterized constructor accepts arguments to initialize an object's fields with specific values.

Example:

```java
class Student {

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

Usage:

```java
Student s1 = new Student("Naim", 21);
Student s2 = new Student("Rahim", 22);
```

Each object receives its own initial values.

---

## 5. Default vs No-Argument Constructor

| Feature | Default Constructor | No-Argument Constructor |
|---|---|---|
| Created by | Java compiler | Programmer |
| Parameters | None | None |
| Custom initialization | Not unless explicitly coded | Yes |
| When available | Only when no constructor is declared | Whenever explicitly declared |
| Main purpose | Compiler-provided initialization | Programmer-defined initialization |

**Interview tip:** A compiler-generated default constructor is itself a no-argument constructor. However, not every no-argument constructor is a compiler-generated default constructor.

---

## 6. Parameterized Constructor

Parameterized constructors are useful when different objects need different initial values.

```java
class Employee {

    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}
```

Main class:

```java
public class Main {

    public static void main(String[] args) {

        Employee e1 = new Employee("Naim", 30000);
        Employee e2 = new Employee("Rahim", 40000);

        e1.display();
        e2.display();
    }
}
```

Output:

```text
Name: Naim
Salary: 30000.0

Name: Rahim
Salary: 40000.0
```

**Key concept:** One class can create many objects, and each object can hold different field values.

---

## 7. The `this` Keyword

### Interview Definition

The `this` keyword is a reference to the current object. It is commonly used to distinguish instance variables from parameters with the same names.

Example:

```java
class Student {

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

Explanation:

```java
this.name = name;
```

- `this.name` refers to the instance variable.
- `name` refers to the constructor parameter.

Without `this`, assigning `name = name` would only refer to the parameter and would not initialize the instance field.

### Common Uses of `this`

1. Refer to current object's fields.
2. Call another constructor using `this()`.
3. Pass the current object as an argument.
4. Return the current object when appropriate.

---

## 8. Constructor Overloading

### Interview Definition

Constructor overloading is the practice of defining multiple constructors in the same class with different parameter lists.

Example:

```java
class Product {

    String name;
    double price;

    Product() {
        this.name = "Unknown";
        this.price = 0.0;
    }

    Product(String name) {
        this.name = name;
        this.price = 0.0;
    }

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
```

Usage:

```java
Product p1 = new Product();
Product p2 = new Product("Keyboard");
Product p3 = new Product("Mouse", 1200);
```

Java selects the appropriate constructor based on the arguments.

### Important Rules

- Constructors must differ in parameter lists.
- Changing only parameter names does not overload a constructor.
- Changing only the return type is not possible because constructors have no return type.
- Constructor overloading is an example of compile-time polymorphism.

---

## 9. Constructor Chaining Using `this()`

### Interview Definition

Constructor chaining is the process of one constructor invoking another constructor in the same class or a superclass.

The `this()` syntax invokes another constructor in the same class.

Example:

```java
class Employee {

    String name;
    double salary;

    Employee() {
        this("Unknown", 0.0);
    }

    Employee(String name) {
        this(name, 0.0);
    }

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
```

Explanation:

- `Employee()` calls `Employee(String, double)`.
- `Employee(String)` calls `Employee(String, double)`.
- The final constructor performs the initialization.

### Important Rules

- A `this()` constructor invocation must be the first statement in a constructor.
- A constructor cannot directly or indirectly call itself in a cycle.
- Constructor chaining helps reduce duplicated initialization code.

**Java version note:** In Java 8–21, `this()` must be the first statement. Java 25 and later support restricted statements before an explicit constructor invocation under the flexible constructor body rules introduced by JEP 513. For conventional code and compatibility, placing `this()` first remains the clearest practice.

---

## 10. Constructor and `super()`

### Interview Definition

The `super()` constructor invocation calls a constructor of the immediate superclass.

Example:

```java
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
```

Usage:

```java
Student s1 = new Student("Naim", 101);
```

### Execution Flow

1. A `Student` object is requested.
2. The superclass constructor initializes the inherited `name` field.
3. The subclass constructor initializes `studentId`.

### `this()` vs `super()`

| `this()` | `super()` |
|---|---|
| Calls another constructor in the same class | Calls a superclass constructor |
| Used for constructor reuse | Used for superclass initialization |
| Must be first in conventional constructor syntax | Must be first in conventional constructor syntax |

You cannot explicitly invoke both `this()` and `super()` in the same constructor because both would occupy the required first position. A chained constructor may invoke the superclass constructor indirectly.

---

## 11. Constructor vs Method

| Feature | Constructor | Method |
|---|---|---|
| Purpose | Initialize an object | Perform an operation |
| Name | Same as class name | Any valid method name |
| Return type | None | Required, including `void` |
| Invocation | During object construction | Called explicitly or through other code |
| Inheritance | Not inherited | Can be inherited, subject to access |
| Overloading | Supported | Supported |
| Overriding | Not supported | Supported for eligible instance methods |

Example:

```java
class Student {

    String name;

    Student(String name) {
        this.name = name;
    }

    void displayName() {
        System.out.println(name);
    }
}
```

`Student(String name)` is a constructor.

`displayName()` is a method.

---

## 12. Access Modifiers in Constructors

Constructors can use access modifiers to control where objects may be created.

| Modifier | Accessibility |
|---|---|
| `public` | From anywhere the class is accessible |
| `protected` | Same package and eligible subclasses |
| Package-private | Same package |
| `private` | Only within the declaring class, subject to Java access rules |

Example:

```java
class Student {

    private Student() {
        System.out.println("Private constructor");
    }

    static Student createStudent() {
        return new Student();
    }
}
```

Usage:

```java
Student s1 = Student.createStudent();
```

A direct call to `new Student()` from another top-level class is not permitted because the constructor is private.

---

## 13. Private Constructors

### Interview Definition

A private constructor prevents ordinary object construction from outside its declaring class. It is commonly used in utility classes and Singleton implementations.

Example of a utility class:

```java
final class MathUtils {

    private MathUtils() {
        // Prevent instantiation
    }

    static int add(int a, int b) {
        return a + b;
    }
}
```

Usage:

```java
int result = MathUtils.add(10, 20);
```

Output:

```text
30
```

Because `add()` is static, no `MathUtils` object is required.

**Important:** Private constructors are not a universal guarantee that only one object can ever exist. Reflection, serialization-related mechanisms, and other advanced Java features may require additional consideration.

---

## 14. Constructor Best Practices

1. Initialize required fields through constructors.
2. Use `this.field = field` when parameters share field names.
3. Validate input before storing it.
4. Keep constructors focused on establishing a valid object state.
5. Use constructor chaining to reduce duplicate initialization.
6. Avoid unnecessarily complex operations inside constructors.
7. Make fields `private` when using encapsulation.
8. Use `final` for fields that should not change after initialization.
9. Avoid publishing the current object from a constructor before initialization is complete.
10. Choose access modifiers based on how objects should be created.

Example with validation:

```java
class BankAccount {

    private final String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialBalance) {

        if (accountHolder == null || accountHolder.isBlank()) {
            throw new IllegalArgumentException(
                "Account holder is required"
            );
        }

        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                "Balance cannot be negative"
            );
        }

        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
}
```

This constructor ensures that an account cannot be created with a missing account holder or a negative initial balance through this construction path.

---

## 15. Real-World Example

### Bank Account Management

```java
class BankAccount {

    private final String accountHolder;
    private final String accountNumber;
    private double balance;

    public BankAccount(
            String accountHolder,
            String accountNumber,
            double initialBalance) {

        if (accountHolder == null || accountHolder.isBlank()) {
            throw new IllegalArgumentException(
                "Account holder is required"
            );
        }

        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException(
                "Account number is required"
            );
        }

        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                "Initial balance cannot be negative"
            );
        }

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit must be positive"
            );
        }

        balance += amount;
    }

    public void displayAccount() {
        System.out.println("Holder: " + accountHolder);
        System.out.println("Account: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

public class Main {

    public static void main(String[] args) {

        BankAccount account =
            new BankAccount("Naim", "ACC1001", 5000);

        account.deposit(1500);
        account.displayAccount();
    }
}
```

Output:

```text
Holder: Naim
Account: ACC1001
Balance: 6500.0
```

This example demonstrates constructor initialization, encapsulation, validation, and maintaining an object's valid state.

---

## 16. Constructor Interview Questions

### Beginner Level

**Q1. What is a constructor in Java?**

A constructor is a special class member used to initialize an object when it is created. It has the same name as the class and no return type.

**Q2. Why do we use constructors?**

To initialize fields, establish an object's initial state, and enforce initialization requirements.

**Q3. Can a constructor return a value?**

A constructor has no return type. It cannot declare `void` or another return type.

**Q4. Can a constructor be overloaded?**

Yes. A class can have multiple constructors with different parameter lists.

**Q5. Can a constructor be inherited?**

No. Constructors are not inherited by subclasses.

**Q6. Can a constructor be overridden?**

No. Constructor overriding is not supported.

**Q7. What happens if we do not write a constructor?**

The compiler provides a default constructor, provided the class declares no constructor of its own.

### Intermediate Level

**Q8. What is the difference between a default constructor and a parameterized constructor?**

The compiler supplies a default constructor when needed; a parameterized constructor accepts arguments to initialize fields.

**Q9. Can we define a private constructor?**

Yes. It can restrict ordinary object creation from outside the class.

**Q10. What is constructor chaining?**

It is the process of one constructor invoking another constructor in the same class or its superclass.

**Q11. What is the difference between `this()` and `super()`?**

`this()` invokes another constructor in the current class; `super()` invokes a superclass constructor.

**Q12. Can a constructor be static?**

No. Constructors cannot be declared `static` because they initialize instances rather than belonging to the class itself.

**Q13. Can a constructor be final?**

No. The `final` modifier cannot be applied to a constructor.

**Q14. Can an abstract class have a constructor?**

Yes. An abstract class can have constructors that initialize its state when a concrete subclass is instantiated.

**Q15. Can an interface have a constructor?**

No. Interfaces do not have constructors.

**Q16. What happens if a class defines only a parameterized constructor?**

The compiler does not provide a no-argument default constructor. Calling `new ClassName()` fails unless a suitable no-argument constructor is declared.

### Advanced Level

**Q17. Can a constructor call another constructor?**

Yes. Use `this()` for a constructor in the same class and `super()` for a superclass constructor.

**Q18. Can a constructor throw an exception?**

Yes. A constructor can throw checked or unchecked exceptions. Checked exceptions must be handled or declared appropriately.

**Q19. What is the role of constructors in immutable classes?**

Constructors initialize the state of an object. Immutable classes commonly use constructors to establish all required field values and prevent subsequent state changes.

**Q20. How are constructors related to design patterns?**

Constructors are used in object creation across many design patterns. For example, a private constructor can support a Singleton implementation, while a Builder can help construct objects with many optional parameters.

---

## 17. Connection to Design Patterns

A design pattern is a reusable solution to a commonly occurring software design problem. Constructors are important in several patterns.

### 17.1 Singleton Pattern

**Interview definition:** The Singleton pattern restricts a class to one instance and provides a shared access point to that instance.

Example:

```java
public final class Singleton {

    private static final Singleton INSTANCE =
        new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```

Usage:

```java
Singleton a = Singleton.getInstance();
Singleton b = Singleton.getInstance();

System.out.println(a == b);
```

Output:

```text
true
```

The private constructor prevents ordinary external instantiation, and the static field stores the shared instance.

For more advanced applications, consider class-loader boundaries, reflection, and serialization. An enum-based Singleton is often a robust Java option.

### 17.2 Builder Pattern

**Interview definition:** The Builder pattern separates the construction of a complex object from its representation, allowing an object to be assembled step by step.

It is especially useful when an object has many optional fields.

Example:

```java
class User {

    private final String name;
    private final int age;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    static class Builder {

        private String name;
        private int age;

        Builder setName(String name) {
            this.name = name;
            return this;
        }

        Builder setAge(int age) {
            this.age = age;
            return this;
        }

        User build() {
            return new User(this);
        }
    }
}
```

Usage:

```java
User user = new User.Builder()
    .setName("Naim")
    .setAge(21)
    .build();
```

The Builder gathers the values, and the private constructor creates the final object.

### 17.3 Factory Pattern

**Interview definition:** The Factory pattern encapsulates object creation so client code can request an object without directly managing all construction details.

Example:

```java
interface Notification {
    void send();
}

class EmailNotification implements Notification {

    public void send() {
        System.out.println("Sending email");
    }
}

class SmsNotification implements Notification {

    public void send() {
        System.out.println("Sending SMS");
    }
}

class NotificationFactory {

    static Notification create(String type) {

        if ("email".equalsIgnoreCase(type)) {
            return new EmailNotification();
        }

        if ("sms".equalsIgnoreCase(type)) {
            return new SmsNotification();
        }

        throw new IllegalArgumentException(
            "Unsupported notification type"
        );
    }
}
```

Usage:

```java
Notification notification =
    NotificationFactory.create("email");

notification.send();
```

The factory centralizes the choice of implementation.

**Important:** This is a simple factory example that demonstrates the concept. The term "Factory Pattern" is often used broadly; the classic Factory Method pattern has a more specific structure.

### Which Pattern Should You Learn First?

Recommended order:

1. Singleton — understand restricted object creation.
2. Factory Method — understand separating creation from use.
3. Builder — understand constructing complex objects.
4. Prototype — understand creating objects by copying existing instances.
5. Abstract Factory — understand creating families of related objects.

Constructors are a foundation for understanding object creation, but learning constructors alone does not mean you have mastered design patterns.

---

## 18. Practice Problems

Try to solve these problems without looking at the examples.

### Beginner

- [ ] Create a `Student` class with a no-argument constructor.
- [ ] Create a parameterized constructor that accepts name and age.
- [ ] Create two objects with different values.
- [ ] Explain the difference between a constructor and a method.

### Intermediate

- [ ] Create a `Book` class with title, author, and price.
- [ ] Implement constructor overloading for the `Book` class.
- [ ] Use `this()` to reduce duplicated initialization code.
- [ ] Use `super()` to initialize fields inherited from a parent class.
- [ ] Validate constructor arguments and throw exceptions for invalid values.

### Advanced

- [ ] Implement a Singleton class.
- [ ] Implement a simple Factory that creates different notification types.
- [ ] Build an immutable `Employee` class.
- [ ] Implement a Builder for a class with at least five fields.
- [ ] Explain when constructor overloading becomes difficult to maintain and when a Builder is more appropriate.

---

## 19. Quick Revision

| Concept | One-line definition |
|---|---|
| Constructor | Initializes an object during creation |
| Default constructor | Compiler-provided no-argument constructor when none is declared |
| No-argument constructor | Constructor with no parameters |
| Parameterized constructor | Constructor that accepts parameters |
| Constructor overloading | Multiple constructors with different parameter lists |
| `this` | Reference to the current object |
| `this()` | Invokes another constructor in the same class |
| `super()` | Invokes a superclass constructor |
| Private constructor | Restricts ordinary object creation from outside the class |
| Constructor chaining | One constructor delegates to another constructor |
| Singleton | Pattern intended to provide one shared instance |
| Builder | Pattern for constructing objects step by step |
| Factory | Encapsulates object-creation decisions |

### Final Interview Answer

**What is a constructor in Java?**

A constructor is a special member of a class used to initialize an object during its creation. It has the same name as the class and does not have a return type. Java supports compiler-generated default constructors and programmer-defined constructors, including no-argument and parameterized constructors. Constructors can be overloaded, and constructor chaining can be performed using `this()` and `super()`.

---

## 📖 Recommended Learning Order

1. Classes and objects
2. Instance variables and methods
3. Constructors
4. `this` and `super`
5. Encapsulation
6. Inheritance and polymorphism
7. Abstraction and interfaces
8. SOLID principles
9. Design patterns
10. Dependency injection and practical application architecture

**Goal:** Understand not only how to write a constructor, but also why object creation should be designed carefully in maintainable Java applications.
