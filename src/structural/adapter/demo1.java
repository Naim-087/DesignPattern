package structural.adapter;

interface Target {
    void request();
}

// Existing class
class Adaptee {

    public void specificRequest() {
        System.out.println("Adaptee is working");
    }
}

// Object Adapter
class Adapter implements Target {

    // Composition
    private Adaptee adaptee;

    // Constructor Injection
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    // Implement Target's contract
    @Override
    public void request() {

        // Delegation
        adaptee.specificRequest();
    }
}

public class demo1 {

    public static void main(String[] args) {

        // Create Adaptee object
        Adaptee adaptee = new Adaptee();

        // Pass Adaptee object to Adapter
        Target target = new Adapter(adaptee);

        // Call Target method
        target.request();
    }
}
