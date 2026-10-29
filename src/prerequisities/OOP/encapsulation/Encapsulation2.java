package prerequisities.OOP.encapsulation;

class Product {

    private String productName;
    private double price;
    private int quantity;

    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters with validation
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }

    // Calculate total inventory value
    public double calculateTotalValue() {
        return price * quantity;
    }

    public void displayInformation() {
        System.out.println("Product Information");
        System.out.println("-------------------");
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Value: $" + calculateTotalValue());
    }

}

public class Encapsulation2 {
    public static void main(String[] args) {

        Product product = new Product("Laptop", 850.00, 5);

        // Display product information
        product.displayInformation();

        // Update product details
        product.setPrice(900.00);
        product.setQuantity(3);

        System.out.println("\nAfter Updating:");
        product.displayInformation();
    }
}
