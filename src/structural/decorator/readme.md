# Decorator Design Pattern

## 1. Definition
The **Decorator Pattern** is a structural design pattern that adds new responsibilities or behavior to an individual object dynamically, without changing its original class. It wraps an object with another object that follows the same interface.

## 2. Purpose
- Add features to an object at runtime.
- Extend behavior without modifying the original class.
- Combine optional features in different ways.
- Avoid creating many subclasses for every feature combination.

## 3. Problem It Solves
Suppose an application offers a basic coffee with optional additions such as milk, sugar, or an extra espresso shot. Creating a separate subclass for every possible combination can lead to too many classes and make the system difficult to maintain.

**Solution:** Wrap the basic coffee object with decorators. Each decorator adds one feature while keeping the same interface. Multiple decorators can be combined as needed.

## 4. How It Works
1. **Component:** Defines the common interface.
2. **Concrete Component:** Provides the basic functionality.
3. **Base Decorator:** Implements the Component interface and stores a reference to a Component object.
4. **Concrete Decorator:** Adds a specific responsibility and delegates the original operation to the wrapped object.
5. **Client:** Uses the component and can combine decorators.

## 5. Real-World Example
Imagine ordering a basic coffee:
- **Basic Coffee:** Provides the original coffee.
- **Milk Decorator:** Adds milk.
- **Sugar Decorator:** Adds sugar.
- **Extra Espresso Decorator:** Adds an extra espresso shot.

Each addition wraps the previous coffee object. This allows different combinations without creating a separate class for every possible order.

## 6. Advantages
- Adds behavior without changing existing classes.
- Supports flexible combinations of features.
- Encourages reuse through small, focused decorators.
- Reduces the need for numerous subclasses.
- Supports the Open/Closed Principle by allowing behavior to be extended without modifying existing code.

## 7. Disadvantages
- Creates additional objects and layers of wrapping.
- Many decorators can make the object structure harder to understand or debug.
- The order of decorators may affect the final behavior.

## 8. When to Use
Use the Decorator Pattern when:
- You need to add optional features to individual objects.
- Features must be combined in different ways.
- Subclassing would create too many classes.
- You want to extend behavior without modifying the original class.

## 9. Main Participants

| Participant | Responsibility |
|---|---|
| Component | Defines the common interface. |
| Concrete Component | Provides the original/basic behavior. |
| Base Decorator | Holds a Component reference and follows the same interface. |
| Concrete Decorator | Adds a specific behavior to the wrapped object. |
| Client | Creates and combines components and decorators. |

## 10. Key Concepts
- **Wrapping:** A decorator contains another Component object and adds behavior around it.
- **Same Interface:** A decorator follows the same interface as the object it decorates, so it can be used in its place.
- **Dynamic Extension:** Features can be added by wrapping an object with decorators at runtime.
- **Composition over Inheritance:** The pattern uses object composition rather than relying only on subclassing.

## 11. Quick Exam Summary
The **Decorator Pattern** is a structural design pattern that dynamically adds responsibilities to an object without modifying its original class. It uses composition and wrapping. Decorators follow the same interface as the component they extend, allowing optional features to be combined flexibly. It is useful when subclassing would produce too many classes.

---
**Key Idea:** Decorator wraps an object with another object that follows the same interface and adds extra behavior while preserving the original interface.
