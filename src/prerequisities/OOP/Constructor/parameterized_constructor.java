package prerequisities.OOP.Constructor;

class Booklist {

    String bookname;
    String authName;
    float prize;

    Booklist(String bookname, String authName, float prize) {

        this.bookname = bookname;
        this.authName = authName;
        this.prize = prize;

        // 7. The this Keyword
        // The this keyword is a reference to the current object.
        // It is commonly used to distinguish instance variables from parameters
        // with the same names.

    }

}

public class parameterized_constructor {
    public static void main(String[] args) {
        Booklist b1 = new Booklist("Hands-On Machine Learning with Scikit-Learn,", "Aurélien Géron", 89.99f);
        Booklist b2 = new Booklist("Python for Data Analysis", "Wes McKinney", 67.78f);

        System.out.println(b1.bookname + "   " + b1.authName + "   " + b1.prize);
        System.out.println(b2.bookname + "   " + b2.authName + "   " + b2.prize);
    }
}
