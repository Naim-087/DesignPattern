package prerequisities.OOP.polymorphism;

//Runtime Polymorphism (Method Overriding & Dynamic Dispatch)

// 1. Base Class
abstract class Animal {
    public abstract void makeSound();
}

// 2. Subclass A
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog says: Woof Woof!");
    }
}

// 3. Subclass B
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat says: Meow!");
    }
}

// 4. Client Code leveraging Polymorphism

public class runtime1 {
    public static void main(String[] args) {
        // Parent class reference holding child class objects
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        // The exact method executed is determined at RUNTIME
        playWithAnimal(myDog); // Output: Dog says: Woof Woof!
        playWithAnimal(myCat); // Output: Cat says: Meow!
    }

    // This method does not need to change when new animals are introduced
    public static void playWithAnimal(Animal animal) {
        animal.makeSound();
    }
}
