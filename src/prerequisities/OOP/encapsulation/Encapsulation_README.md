# Java OOP — Encapsulation

A structured, beginner-friendly guide to **encapsulation in Java**, with interview definitions, examples, access modifiers, validation, practical exercises, and connections to maintainable software design.

> **Learning goal:** Learn how to protect an object's internal state, control how it changes, and design classes with clear responsibilities—important foundations for SOLID principles and design patterns.

## Table of Contents

1. [What Is Encapsulation?](#1-what-is-encapsulation)
2. [Why Is Encapsulation Important?](#2-why-is-encapsulation-important)
3. [The Four OOP Principles](#3-the-four-oop-principles)
4. [How Encapsulation Works in Java](#4-how-encapsulation-works-in-java)
5. [Access Modifiers](#5-access-modifiers)
6. [Getters and Setters](#6-getters-and-setters)
7. [Validation and Data Integrity](#7-validation-and-data-integrity)
8. [Encapsulation vs Data Hiding](#8-encapsulation-vs-data-hiding)
9. [A Practical Bank Account Example](#9-a-practical-bank-account-example)
10. [Immutable Objects](#10-immutable-objects)
11. [Common Mistakes](#11-common-mistakes)
12. [Encapsulation and Design Principles](#12-encapsulation-and-design-principles)
13. [Interview Questions and Answers](#13-interview-questions-and-answers)
14. [Practice Exercises](#14-practice-exercises)
15. [Suggested Folder Structure](#15-suggested-folder-structure)
16. [Quick Revision](#16-quick-revision)

---

## 1. What Is Encapsulation?

### Interview definition

**Encapsulation is an object-oriented programming principle that bundles data and the methods that operate on that data into a single unit, while controlling access to the object's internal state.**

In Java, encapsulation is commonly implemented by declaring fields `private` and exposing carefully designed public methods when access or modification is needed.

### Simple explanation

Think of a bank account. You should not be able to change its balance to an arbitrary value from anywhere in the program. Instead, the account provides operations such as `deposit()` and `withdraw()` that enforce its rules.

Encapsulation allows a class to control **how its data is read and changed**.

Key terms:

- **State:** The data stored inside an object.
- **Behavior:** The methods that operate on that data.
- **Data hiding:** Restricting direct access to implementation details.
- **Validation:** Checking input before accepting a state change.

---

## 2. Why Is Encapsulation Important?

Encapsulation helps you:

- Protect an object's state from invalid changes.
- Apply validation in one place.
- Reduce unnecessary dependencies on implementation details.
- Make code easier to maintain and test.
- Change internal implementation without requiring every caller to change.
- Define a clear public API for a class.

For example, a `BankAccount` should reject a negative deposit. Centralizing that rule inside `deposit()` is safer than expecting every caller to remember it.

---

## 3. The Four OOP Principles

| Principle | Main idea |
|---|---|
| Encapsulation | Control access to an object's state and behavior |
| Abstraction | Expose essential operations while hiding unnecessary implementation details |
| Inheritance | Create a class based on another class |
| Polymorphism | Use a common type to work with different implementations |

**Focus here:** Encapsulation and abstraction are related, but not identical. Encapsulation organizes state and behavior with controlled access; abstraction focuses on presenting a simpler interface.

---

## 4. How Encapsulation Works in Java

### Without encapsulation

```java
class Student {
    public String name;
    public int age;
}
```

Usage:

```java
Student student = new Student();

student.name = "Naim";
student.age = -10; // Invalid, but allowed
```

Any code with access to the object can directly assign an invalid age.

### With encapsulation

**File: `Student.java`**

```java
public class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                "Name cannot be empty"
            );
        }

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(
                "Age cannot be negative"
            );
        }

        this.age = age;
    }
}
```

**File: `Main.java`**

```java
public class Main {

    public static void main(String[] args) {
        Student student = new Student("Naim", 21);

        System.out.println(student.getName());
        System.out.println(student.getAge());

        student.setAge(22);
        System.out.println(student.getAge());

        // Throws IllegalArgumentException:
        // student.setAge(-5);
    }
}
```

### What changed?

1. Fields are `private`, so outside code cannot access them directly.
2. Public methods provide controlled access.
3. Validation rejects invalid values.
4. The class itself is responsible for protecting its state.

**Important:** Encapsulation does not require a getter and setter for every field. Expose only the operations the class actually needs.

---

## 5. Access Modifiers

Java provides access modifiers to control visibility.

| Modifier | Same class | Same package | Subclass in another package | Unrelated class in another package |
|---|---:|---:|---:|---:|
| `private` | Yes | No | No direct access | No |
| Package-private (no modifier) | Yes | Yes | No | No |
| `protected` | Yes | Yes | Yes, subject to subclass access rules | No |
| `public` | Yes | Yes | Yes | Yes, if the type itself is accessible |

### Example

```java
class Employee {

    private double salary;
    public String name;
}
```

- `salary` can only be accessed directly inside `Employee`.
- `name` can be accessed from other code wherever `Employee` itself is accessible.

**Best practice:** Use `private` for fields by default, then expose a deliberate public interface.

---

## 6. Getters and Setters

### Getter

A getter returns a value without directly exposing the field.

```java
public int getAge() {
    return age;
}
```

### Setter

A setter updates a field, optionally applying validation.

```java
public void setAge(int age) {
    if (age < 0) {
        throw new IllegalArgumentException(
            "Age cannot be negative"
        );
    }

    this.age = age;
}
```

### Do all fields need getters and setters?

No. Automatically generating a getter and setter for every field can weaken encapsulation by exposing unnecessary operations.

For example, a bank account should not normally have this method:

```java
public void setBalance(double balance) {
    this.balance = balance;
}
```

It allows arbitrary balance replacement and bypasses deposit and withdrawal rules.

Prefer meaningful operations such as:

```java
account.deposit(500);
account.withdraw(200);
```

**Key principle:** Expose behavior, not merely fields.

---

## 7. Validation and Data Integrity

Encapsulation becomes especially useful when a class must maintain invariants.

An **invariant** is a condition that should remain true for every valid object state.

Examples:

- An account balance cannot become negative if overdrafts are not allowed.
- A product price cannot be negative.
- A student's age cannot be negative.
- A required identifier cannot be blank.

**File: `Product.java`**

```java
public class Product {

    private final String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        if (productId == null || productId.isBlank()) {
            throw new IllegalArgumentException(
                "Product ID is required"
            );
        }

        this.productId = productId;
        setName(name);
        setPrice(price);
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                "Product name is required"
            );
        }

        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException(
                "Price must be finite and non-negative"
            );
        }

        this.price = price;
    }
}
```

Here, the product ID is fixed after construction, while the name and price can change only through validated methods.

For financial applications, `BigDecimal` is usually preferable to `double` for monetary amounts.

---

## 8. Encapsulation vs Data Hiding

These terms are related but not exactly interchangeable.

| Encapsulation | Data hiding |
|---|---|
| Bundles data and behavior and controls access | Restricts access to internal details |
| A broader design principle | One technique or goal supported by encapsulation |
| Achieved through class design and controlled interfaces | Often implemented with `private` and appropriate access control |

**Interview answer:** Data hiding is an important part of encapsulation, but encapsulation also concerns grouping state and behavior and defining a controlled interface.

---

## 9. A Practical Bank Account Example

**File: `BankAccount.java`**

```java
public class BankAccount {

    private final String accountNumber;
    private final String accountHolder;
    private double balance;

    public BankAccount(
            String accountNumber,
            String accountHolder,
            double initialBalance) {

        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException(
                "Account number is required"
            );
        }

        if (accountHolder == null || accountHolder.isBlank()) {
            throw new IllegalArgumentException(
                "Account holder is required"
            );
        }

        if (!Double.isFinite(initialBalance)
                || initialBalance < 0) {
            throw new IllegalArgumentException(
                "Initial balance must be non-negative"
            );
        }

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit amount must be positive and finite"
            );
        }

        balance += amount;
    }

    public void withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException(
                "Withdrawal amount must be positive and finite"
            );
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                "Insufficient balance"
            );
        }

        balance -= amount;
    }
}
```

**File: `BankAccountDemo.java`**

```java
public class BankAccountDemo {

    public static void main(String[] args) {

        BankAccount account =
            new BankAccount("ACC-1001", "Naim", 5000);

        account.deposit(1500);
        account.withdraw(1000);

        System.out.println(
            "Account holder: " + account.getAccountHolder()
        );

        System.out.println(
            "Current balance: " + account.getBalance()
        );

        // Not allowed:
        // account.balance = 100000;
        // account.setBalance(100000);
    }
}
```

Expected output:

```text
Account holder: Naim
Current balance: 5500.0
```

### What does this demonstrate?

- **Private state:** Fields cannot be changed directly from outside the class.
- **Controlled modification:** Balance changes through `deposit()` and `withdraw()`.
- **Validation:** Invalid transactions are rejected.
- **Read-only access:** Getters expose account information without exposing direct field modification.
- **Constructor validation:** Invalid initial state is rejected before construction completes.

This is an educational example. A production banking system would need additional considerations, including precise monetary types, concurrency, authorization, and transaction handling.

---

## 10. Immutable Objects

### Interview definition

An immutable object is an object whose observable state cannot change after it has been constructed.

Encapsulation can help implement immutability.

**File: `Employee.java`**

```java
public final class Employee {

    private final int employeeId;
    private final String name;

    public Employee(int employeeId, String name) {
        if (employeeId <= 0) {
            throw new IllegalArgumentException(
                "Employee ID must be positive"
            );
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                "Name is required"
            );
        }

        this.employeeId = employeeId;
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }
}
```

This class has:

- A `final` class declaration to prevent subclassing.
- `private final` fields.
- No setters.
- Validation during construction.

Both fields use immutable types (`int` and `String`), so no defensive copying is required here.

For mutable fields such as lists or dates, additional defensive copying may be needed.

---

## 11. Common Mistakes

1. Making every field `public`.
2. Creating unrestricted setters for every field.
3. Allowing invalid values without validation.
4. Confusing encapsulation with simply writing getters and setters.
5. Returning a mutable internal collection directly.
6. Exposing implementation details that callers do not need.
7. Putting business rules in every caller instead of enforcing them inside the class.
8. Assuming `private` alone makes an entire object immutable.
9. Using inheritance when composition is more appropriate.
10. Treating access modifiers as a replacement for authorization or security checks.

### Avoid exposing mutable collections

Risky approach:

```java
public List<String> getRoles() {
    return roles;
}
```

Callers could modify the internal list if they receive the actual mutable object.

Safer alternative:

```java
public List<String> getRoles() {
    return List.copyOf(roles);
}
```

`List.copyOf` returns an unmodifiable snapshot of the list's elements. If those elements are themselves mutable objects, this does not make the elements immutable.

---

## 12. Encapsulation and Design Principles

Encapsulation is a foundation for designing classes with clear boundaries.

### Single Responsibility Principle (SRP)

**Definition:** A class should have one responsibility, or one coherent reason to change.

A `BankAccount` should own the rules for its balance rather than requiring every caller to implement those rules independently.

### Open/Closed Principle (OCP)

**Definition:** Software entities should be open for extension but closed for modification.

A stable public interface can allow internal implementation changes without requiring every caller to change.

### Dependency Inversion Principle (DIP)

**Definition:** High-level modules should depend on abstractions rather than concrete implementations.

Encapsulation helps define boundaries, while interfaces and dependency injection can help separate components.

### Connection to design patterns

- **Builder:** Encapsulates the process of assembling an object with multiple configuration options.
- **Factory Method:** Encapsulates object-creation decisions behind a creation method.
- **Strategy:** Encapsulates interchangeable algorithms behind a common interface.
- **Facade:** Encapsulates a complex subsystem behind a simpler interface.

Encapsulation is not itself a design pattern; it is an OOP principle used throughout good object-oriented designs.

---

## 13. Interview Questions and Answers

### Beginner level

**Q1. What is encapsulation in Java?**

Encapsulation is an OOP principle that combines data and related behavior in a class while controlling access to the object's internal state.

**Q2. How do you achieve encapsulation in Java?**

Commonly by declaring fields `private` and providing carefully designed public methods for permitted operations.

**Q3. What is the main purpose of encapsulation?**

To protect object state, enforce rules, reduce coupling, and provide a controlled interface.

**Q4. What are getters and setters?**

Getters read field values, while setters update field values and can validate proposed changes.

**Q5. Does every private field need a getter and setter?**

No. Only expose the operations needed by the class's users.

### Intermediate level

**Q6. What is the difference between encapsulation and data hiding?**

Encapsulation bundles state and behavior with controlled access. Data hiding specifically restricts access to internal details and is one aspect of encapsulation.

**Q7. Can encapsulation be achieved without setters?**

Yes. Read-only classes, immutable objects, and classes exposing domain-specific operations can be well encapsulated without setters.

**Q8. What is an invariant?**

An invariant is a condition that must remain true for every valid state of an object.

**Q9. Why should fields usually be private?**

Private fields prevent arbitrary direct access and allow the class to control validation and state changes.

**Q10. What is the difference between `private` and `protected`?**

`private` restricts direct access to the declaring class. `protected` allows access within the package and, subject to Java's rules, from subclasses in other packages.

**Q11. Is a class immutable if all its fields are private?**

No. Private fields may still be changed by methods. Immutability requires that observable state cannot change after construction.

**Q12. How does encapsulation improve maintainability?**

Callers depend on a public interface rather than internal details, so the implementation can change without necessarily breaking callers.

### Advanced level

**Q13. What is the difference between encapsulation and abstraction?**

Encapsulation controls how state and behavior are organized and accessed. Abstraction exposes essential functionality while hiding unnecessary implementation complexity.

**Q14. How does encapsulation support SOLID principles?**

It helps define clear responsibilities and stable interfaces, which can support SRP, OCP, and dependency-oriented designs. It does not automatically guarantee SOLID compliance.

**Q15. Why can unrestricted setters be harmful?**

They can allow invalid state changes, bypass business rules, and make it difficult to preserve invariants.

**Q16. How do you encapsulate a mutable collection?**

Avoid returning the internal mutable collection directly. Use defensive copies, unmodifiable views, or controlled collection operations according to the requirements.

**Q17. Is encapsulation a design pattern?**

No. It is a fundamental OOP principle. Design patterns use encapsulation to organize responsibilities and hide implementation details.

**Q18. How does encapsulation relate to the Builder pattern?**

A Builder can collect and validate configuration before constructing an object. The target class can keep its fields private and expose only its intended operations.

**Q19. Does encapsulation guarantee security?**

No. It helps control access at the object API level, but application security also requires authentication, authorization, input handling, and other safeguards.

**Q20. What is the difference between an immutable object and an encapsulated object?**

An encapsulated object controls access to its state; an immutable object cannot change its observable state after construction. An object can be encapsulated without being immutable.

---


### Level 4 — Design thinking

- [ ] Explain why `setBalance()` is a poor API for the bank account.
- [ ] Identify invariants in a library book or inventory system.
- [ ] Design a class that exposes behavior instead of unrestricted setters.
- [ ] Explain how a Builder can construct an object with optional fields.
- [ ] Describe how encapsulation makes unit testing and refactoring easier.

---

## 15. Suggested Folder Structure

```text
Encapsulation/
├── README.md
├── BasicEncapsulation.java
├── Student.java
├── StudentDemo.java
├── Product.java
├── ProductDemo.java
├── BankAccount.java
├── BankAccountDemo.java
├── ImmutableEmployee.java
├── CollectionEncapsulation.java
└── exercises/
    ├── StudentExercise.java
    ├── ProductExercise.java
    └── BankAccountExercise.java
```

**Java file rule:** A `public` top-level class must be saved in a file with the same name as the class. For example, `public class Student` belongs in `Student.java`.

---


### Final interview answer

**What is encapsulation in Java?**

Encapsulation is an object-oriented programming principle that bundles data and the methods operating on that data into a class while controlling access to the object's internal state. In Java, it is commonly implemented using private fields and carefully designed public methods. It supports data integrity, validation, maintainability, and reduced coupling.

---

