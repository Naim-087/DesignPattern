package structural.adapter.project_Spring26;

// Adaptee 1:
// Existing third-party bKash API.
// It has its own method name instead of the standard pay().
public class BkashAPI {

    // Existing bKash payment method.
    public void makeBkashPayment(double amount) {

        System.out.println(
                "Paid BDT " + amount +
                        " successfully via bKash API.");
    }
}