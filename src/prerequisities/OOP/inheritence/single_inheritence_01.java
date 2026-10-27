package prerequisities.OOP.inheritence;

import java.nio.channels.Pipe.SourceChannel;

class Employee {
    int employeeId;
    String name;
    double salary;

    Employee(int employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name : " + name);
        System.out.println("Monthly Salary : " + salary);
    }
}

class FulltimeEmployee extends Employee {
    double increment;

    FulltimeEmployee(int employeeId, String name, double salary, double increment) {

        super(employeeId, name, salary);
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative.");
        }

        this.increment = increment;
    }

    double totalSalary = salary + increment;

    void displaysalary() {
        System.out.println("New salary : " + totalSalary);
    }
}

public class single_inheritence_01 {

    public static void main(String[] args) {
        FulltimeEmployee employee1 = new FulltimeEmployee(303, "Naimul Islam", 45000, 6000);
        FulltimeEmployee employee2 = new FulltimeEmployee(305, "Mahim Khan", 55000, 3000);

        employee1.displayDetails();
        employee1.displaysalary();

        employee2.displayDetails();
        employee2.displaysalary();
    }

}
