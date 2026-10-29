package prerequisities.OOP.polymorphism;

class Calculator {
    // overloaded method 1 : takes 2 integers

    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method 2: takes 3 integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method 3: takes 2 doubles
    public double add(double a, double b) {
        return a + b;
    }

}
// 2. The driver/runner class containing the main method

public class compiletime1 {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Calls add(int, int)
        int sumTwoInts = calc.add(10, 20);
        System.out.println("Sum of two integers (10 + 20): " + sumTwoInts);

        // Calls add(int, int, int)
        int sumThreeInts = calc.add(10, 20, 30);
        System.out.println("Sum of three integers (10 + 20 + 30): " + sumThreeInts);

        // Calls add(double, double)
        double sumTwoDoubles = calc.add(12.5, 7.5);
        System.out.println("Sum of two doubles (12.5 + 7.5): " + sumTwoDoubles);

        // Demonstrating type promotion: int values promoted to double
        double mixedSum = calc.add(5, 4.5);
        System.out.println("Sum with type promotion (5 + 4.5): " + mixedSum);
    }
}
