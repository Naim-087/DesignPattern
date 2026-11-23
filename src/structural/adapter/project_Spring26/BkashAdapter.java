package structural.adapter.project_Spring26;

// Adapter 1:
// Connects the existing BkashAPI with PaymentGateway.
// Implements the standard interface expected by the client.
public class BkashAdapter implements PaymentGateway {

    // Composition: Adapter contains a BkashAPI object.
    private final BkashAPI bkashAPI;

    // Constructor injection: Receives the existing BkashAPI object.
    public BkashAdapter(BkashAPI bkashAPI) {
        this.bkashAPI = bkashAPI;
    }

    // Implements the standard payment method.
    @Override
    public void pay(double amount) {

        // Translates pay() into the existing bKash API method.
        bkashAPI.makeBkashPayment(amount);
    }
}