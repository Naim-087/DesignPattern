package structural.decorator;
/*
A computer manufacturing company named TechWorld is developing a computer configuration system.

Initially, customers can purchase a basic computer with standard specifications.

Customers can customize their computers by adding:
- Extra RAM
- SSD Storage
- Graphics Card
- RGB Keyboard
Each additional component increases the total computer price.
The company wants to allow customers to add multiple components dynamically without creating separate classes for every possible computer configuration.

*/

// Component
interface Computer {
    String getDescription();

    double getCost();
}

// Concrete Component
class BasicComputer implements Computer {
    @Override
    public String getDescription() {
        return "Basic Computer";
    }

    @Override
    public double getCost() {
        return 500.0;
    }
}

// Abstract Decorator
abstract class ComputerDecorator implements Computer {
    protected Computer computer;

    public ComputerDecorator(Computer computer) {
        this.computer = computer;
    }

    @Override
    public String getDescription() {
        return computer.getDescription();
    }

    @Override
    public double getCost() {
        return computer.getCost();
    }
}

// Concrete Decorators
class ExtraRAM extends ComputerDecorator {
    public ExtraRAM(Computer computer) {
        super(computer);
    }

    @Override
    public String getDescription() {
        return computer.getDescription() + " + Extra RAM";
    }

    @Override
    public double getCost() {
        return computer.getCost() + 80.0;
    }
}

class SSDStorage extends ComputerDecorator {
    public SSDStorage(Computer computer) {
        super(computer);
    }

    @Override
    public String getDescription() {
        return computer.getDescription() + " + SSD Storage";
    }

    @Override
    public double getCost() {
        return computer.getCost() + 120.0;
    }
}

class GraphicsCard extends ComputerDecorator {
    public GraphicsCard(Computer computer) {
        super(computer);
    }

    @Override
    public String getDescription() {
        return computer.getDescription() + " + Graphics Card";
    }

    @Override
    public double getCost() {
        return computer.getCost() + 300.0;
    }
}

class RGBKeyboard extends ComputerDecorator {
    public RGBKeyboard(Computer computer) {
        super(computer);
    }

    @Override
    public String getDescription() {
        return computer.getDescription() + " + RGB Keyboard";
    }

    @Override
    public double getCost() {
        return computer.getCost() + 50.0;
    }
}

public class decorator2_realProblemsolve {

    public static void main(String[] args) {
        // Basic computer
        Computer pc = new BasicComputer();
        System.out.println(pc.getDescription() + " = $" + pc.getCost());

        // Add components dynamically
        pc = new ExtraRAM(pc);
        pc = new SSDStorage(pc);
        pc = new GraphicsCard(pc);
        pc = new RGBKeyboard(pc);

        System.out.println(pc.getDescription() + " = $" + pc.getCost());

        // Another configuration: only SSD + RGB Keyboard
        Computer pc2 = new RGBKeyboard(new SSDStorage(new BasicComputer()));
        System.out.println(pc2.getDescription() + " = $" + pc2.getCost());
    }

}
