package prerequisities.OOP.encapsulation;
/*Scenario: Student Management System
A university needs a system to manage student information. Each student has a name and age.
- Student information must not be modified directly from outside the Student class.
- The system should allow reading student information through getter methods.
- The system should allow updating information through setter methods.
- The system must prevent invalid data, such as an empty name or a negative age.
 */

/*Constructor and setter has different use based on use case , 
if an object value is immutable (remain fixed no changes , then we dont need setter)
When we need setter?- for mutable object (an attribute needs to be updated or changed)
*/

class Student {

    private String name;
    private int age;
    private String Id;
    private double Current_cgpa;

    Student(String name, int age, String Id, double cgpa) {
        this.name = name;
        this.age = age;
        this.Id = Id;
        this.Current_cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return Id;
    }

    public double getCgpa() {
        return Current_cgpa;
    }

    // Setter Methodd withh Validationn

    public void setName(String name) {

        if (name == null || name.isBlank()) {

            throw new IllegalArgumentException("Name can not be empty ");
        }

        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(" Age cannot be negative...");
        }
        this.age = age;
    }

    public void setCurrent_cgpa(double Current_cgpa) {

        if (Current_cgpa < 0) {
            throw new IllegalArgumentException("Cgpa must be valid ");
        }

        this.Current_cgpa = Current_cgpa;
    }

    public void display_info() {
        System.out.println(" ");
        System.out.println("Student Information");
        System.out.println("---------------------");

        System.out.println("Student Id : " + Id);
        System.out.println(" Name: " + name);
        System.out.println("Age : " + age);
        System.out.println("Current CGPA : " + Current_cgpa);

    }

}

public class BasicEncapsulation {

    public static void main(String[] args) {

        // Create Student object

        Student S1 = new Student("Khalid bin Walid", 21, "SE212", 3.67);

        Student S2 = new Student("Omar Ibn Jayed", 23, "SE442", 3.80);

        S1.display_info();
        S2.display_info();

        // update Student Information with setter methood
        S2.setAge(21);
        S2.setName("Ibn OMAR");
        S2.setCurrent_cgpa(3.81);

        S2.display_info();

    }

}
