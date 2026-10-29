package prerequisities.OOP.abstraction.Interface;

import javax.sound.sampled.SourceDataLine;

/*An interface is a collection of abstract methods

----> Fully abstraction
----> It supports multiple inheritence

 *** class - class ke extends kore
 *** interface - interface ke extends kore
 *** Class - interface ke implements kore
*/
interface animal {

    abstract void eat();
}

class Cat implements animal {

    @Override
    public void eat() {
        System.out.println("Cat loves milk..");
    }
}

public class Interface1 {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.eat();
    }

}
