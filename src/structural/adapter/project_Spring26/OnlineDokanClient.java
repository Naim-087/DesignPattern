package structural.adapter.project_Spring26;

// Client:
// Online Dokan uses the standard PaymentGateway interface.
// It does not need to know the internal implementation
// of bKash or Rocket payment services.
public class OnlineDokanClient {

    // Client depends on the Target interface, not concrete APIs.
    private final PaymentGateway paymentGateway;

    // Constructor injection: Receives the selected payment gateway.
    public OnlineDokanClient(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    // Processes payment using the standard interface.
    public void checkout(double amount) {

        // Calls the adapter's pay() method.
        // The adapter forwards the request to the appropriate API.
        paymentGateway.pay(amount);
    }

    // Main method: Demonstrates both payment integrations.
    public static void main(String[] args) {

        // ===== 1. bKash Payment =====

        // Create the existing bKash API object.
        BkashAPI bkashAPI = new BkashAPI();

        // Wrap the bKash API with its adapter.
        PaymentGateway bkashGateway = new BkashAdapter(bkashAPI);

        // Pass the adapter to the Online Dokan client.
        OnlineDokanClient order1 = new OnlineDokanClient(bkashGateway);

        // Process payment through bKash.
        order1.checkout(1500.0);

        // ===== 2. Rocket Payment =====

        // Create the existing Rocket API object.
        RocketAPI rocketAPI = new RocketAPI();

        // Wrap the Rocket API with its adapter.
        PaymentGateway rocketGateway = new RocketAdapter(rocketAPI);

        // Pass the adapter to the Online Dokan client.
        OnlineDokanClient order2 = new OnlineDokanClient(rocketGateway);

        // Process payment through Rocket.
        order2.checkout(2500.0);
    }
}