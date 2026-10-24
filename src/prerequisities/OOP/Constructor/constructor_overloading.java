package prerequisities.OOP.Constructor;

/*Interview Definition: 
Constructor overloading is the practice 
of defining multiple constructors in the same class 
with different parameter lists. */
class product {

    String name;
    double price;

    product() {
        name = "Book";
        price = 50.43;
    }

    product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class constructor_overloading {

    public static void main(String[] args) {
        product p1 = new product();
        product p2 = new product("Pencil Box", 5.6);

        System.out.println("product name : " + p1.name + "            " + "product price : " + p1.price);
        System.out.println("product name : " + p2.name + "     " + "product price : " + p2.price);
    }

}
