package structural.decorator;

/// 1. Component
interface Coffee {
    int cost();

    String description();
}

// 2. Concrete Component
class PlainCoffee implements Coffee {
    public int cost() {
        return 50;
    }

    public String description() {
        return "Plain coffee";
    }
}

// 3. Base Decorator: is-a Coffee, has-a Coffee
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

// 4. Concrete Decorators
class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    public int cost() {
        return coffee.cost() + 10;
    }

    public String description() {
        return coffee.description() + " + milk";
    }
}

class Sugar extends CoffeeDecorator {
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    public int cost() {
        return coffee.cost() + 5;
    }

    public String description() {
        return coffee.description() + " + sugar";
    }
}

class Caramel extends CoffeeDecorator {
    public Caramel(Coffee coffee) {
        super(coffee);
    }

    public int cost() {
        return coffee.cost() + 15;
    }

    public String description() {
        return coffee.description() + " + caramel";
    }
}

// 5. Client
public class decorator1 {
    public static void main(String[] args) {
        Coffee order = new PlainCoffee();
        order = new Milk(order);
        order = new Sugar(order);
        order = new Caramel(order);

        System.out.println(order.description()); // Plain coffee + milk + sugar + caramel
        System.out.println(order.cost()); // 80

        // Different combination, no new class needed
        Coffee order2 = new Caramel(new Milk(new PlainCoffee()));
        System.out.println(order2.description()); // Plain coffee + milk + caramel
        System.out.println(order2.cost()); // 75
    }
}
