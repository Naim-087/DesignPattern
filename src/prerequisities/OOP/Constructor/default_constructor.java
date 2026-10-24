//Interview definition: A default constructor is the no-argument constructor implicitly 
//provided by the Java compiler when a class declares no constructor.

package prerequisities.OOP.Constructor;

class student {

    String name;
    int age;

    student() {

        name = "Ibrahim";
        age = 22;

    }
}

public class default_constructor {

    public static void main(String[] args) {
        student s1 = new student();
        System.out.println("Name : " + s1.name + " " + "Age : " + s1.age);
    }

}
