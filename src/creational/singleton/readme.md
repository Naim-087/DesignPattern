# Singleton Design Pattern in Java

## Overview

Singleton is a **creational design pattern** that controls the creation of objects by allowing a class to have only one instance throughout an application.

Normally, we can create multiple objects of a class using the `new` keyword. However, some situations require a single shared object that can be accessed by different parts of the application.

Singleton solves this problem by restricting object creation and providing a common method to access the existing instance.

It is commonly used in logging systems, application configuration, database connection management, and shared resources.

The main idea is simple: **Create one object and make sure everyone uses that same object.**

## Key Features

- **Single Instance:** Ensures that only one instance of the class is created.
- **Controlled Object Creation:** Prevents external classes from directly creating objects.
- **Global Access Point:** Provides a static method such as `getInstance()` to access the shared object.
- **Memory Efficiency:** Avoids unnecessary object creation when one instance is sufficient.
- **Lazy Initialization:** Allows the instance to be created only when it is requested for the first time.
- **Thread Safety:** Can be implemented to prevent multiple threads from creating separate instances.

## When to Use Singleton

- Logging applications where a common logger is required.
- Configuration management where application settings should be shared.
- Database connection management.
- Cache management systems.
- Application-wide resource managers.
- Shared services that should maintain a single state.

---

## Beginner Deep Dive

### Pattern In One Line

Singleton ensures that a class creates only one object and provides a single, controlled way to access it.

### What Is This Pattern?

Singleton is a design pattern in which the class itself takes responsibility for managing its instance.

Instead of allowing other classes to create objects directly, Singleton keeps its constructor private and provides a static method to return its instance.

Whenever another part of the application requests the object, the same instance is returned instead of creating a new one.

### The Core Problem It Solves

Imagine an application where multiple objects of a configuration manager are created.

Each object might maintain different configuration values, resulting in inconsistent application behavior.

Similarly, creating multiple logger or shared resource manager objects may cause unnecessary resource consumption.

Singleton prevents this situation by maintaining one shared instance that different parts of the application can access.

### How It Works Step By Step

1. **Create a private constructor:** Prevent other classes from creating objects using the `new` keyword.
2. **Declare a static instance variable:** Store the single object inside the class.
3. **Create a static access method:** Provide a method named `getInstance()` to access the object.
4. **Check the instance:** If the object does not exist, create it; otherwise, return the existing object.
5. **Return the same instance:** Every method call should provide the same object reference.

### Main Participants

- **Singleton Class:** The class responsible for controlling object creation.
- **Private Constructor:** Restricts object creation from outside the class.
- **Static Instance Variable:** Holds the reference to the single object.
- **Static getInstance() Method:** Provides access to the shared instance.
- **Client:** Any class that requests and uses the Singleton object.

### Simple Diagram

```text
        Client A
           |
        Client B
           |
        Client C
           |
           v
    +----------------+
    |  getInstance() |
    +----------------+
           |
           v
    +----------------+
    |   Singleton    |
    |    Object      |
    +----------------+

  All clients share the
      same instance.
```

### When To Use

- When an application requires exactly one shared instance.
- When multiple objects could create inconsistent application states.
- When a centralized resource needs controlled access.
- When creating additional instances would be unnecessary.

### When Not To Use

- Avoid Singleton when different parts of the application need independent objects.
- Do not use it simply to make an object globally accessible.
- Avoid excessive use of global shared state.
- Do not use it when dependency injection provides a cleaner and more testable solution.

### Advantages

- Ensures a single instance of a class.
- Provides centralized access to a shared object.
- Prevents unnecessary object creation.
- Can support lazy initialization.
- Makes shared resource management easier.

### Disadvantages And Trade-Offs

- Excessive use can introduce global state into an application.
- Incorrect implementation can cause thread-safety problems.
- Can make unit testing more difficult.
- Creates tighter dependencies between classes.
- Requires careful implementation when multithreading is involved.

### Do Not Confuse This With

- **Singleton vs Static Class:** A Singleton is an actual object that can implement interfaces and participate in object-oriented programming. A static utility class provides static members without requiring an instance.
- **Singleton vs Normal Class:** A normal class generally allows multiple objects, whereas Singleton restricts object creation to one instance.
- **Singleton vs Dependency Injection:** Singleton controls how many instances a class creates. Dependency Injection controls how objects receive their dependencies. Dependency Injection can also manage a service with Singleton scope.
- **Eager vs Lazy Initialization:** Eager initialization creates the instance when the class is initialized, while lazy initialization creates it only when it is first requested.

---

**Language:** Java

**Topic:** Creational Design Pattern

**Pattern:** Singleton

**Key Method:** `getInstance()`