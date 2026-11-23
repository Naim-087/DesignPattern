package structural.adapter.project_Spring26;

// Target Interface:
// Defines the standard payment method expected by the client.
// Every payment adapter must implement this interface.
public interface PaymentGateway {

    // Standard method for processing payments.
    void pay(double amount);
}
