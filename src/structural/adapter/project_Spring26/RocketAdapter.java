package structural.adapter.project_Spring26;

// Adapter 2:
// Connects the existing RocketAPI with PaymentGateway.
public class RocketAdapter implements PaymentGateway {

    // Composition: Adapter contains a RocketAPI object.
    private final RocketAPI rocketAPI;

    // Constructor injection: Receives the existing RocketAPI object.
    public RocketAdapter(RocketAPI rocketAPI) {
        this.rocketAPI = rocketAPI;
    }

    // Implements the standard payment method.
    @Override
    public void pay(double amount) {

        // Translates pay() into the existing Rocket API method.
        rocketAPI.sendRocketMoney(amount);
    }
}