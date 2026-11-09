# Adapter Design Pattern

## 1. Definition
The **Adapter Pattern** is a structural design pattern that allows two incompatible interfaces to work together. It converts the interface of an existing class into the interface expected by the client.

## 2. Purpose
- Connect classes with incompatible interfaces.
- Reuse existing code without changing it.
- Make different components work together.

## 3. Problem It Solves
A client expects a particular interface, but an existing class provides a different one. As a result, the client cannot use that class directly.

**Solution:** Create an Adapter that translates the client's requests into calls understood by the existing class.

## 4. How It Works
1. **Client:** Requests a service using the expected interface.
2. **Target:** Defines the interface the client expects.
3. **Adapter:** Converts the request into a form the existing class understands.
4. **Adaptee:** The existing class that has an incompatible interface.

## 5. Real-World Example
A USB-C laptop port cannot directly connect to a USB-A device. A USB adapter converts the connection so the two can work together.

## 6. Advantages
- Reuses existing classes.
- Connects incompatible interfaces.
- Reduces dependency between the client and existing class.
- Makes code easier to maintain and extend.

## 7. When to Use
Use the Adapter Pattern when you want to use an existing class, but its interface does not match the interface required by your application.

---
**Key Point:** Adapter acts as a bridge between incompatible interfaces, allowing them to work together without changing the existing class.
