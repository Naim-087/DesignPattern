package structural.adapter.project_Spring26;

// Adaptee 2:
// Existing third-party Rocket API.
// Its payment method is different from the standard interface.
public class RocketAPI {

    // Existing Rocket payment method.
    public void sendRocketMoney(double amount) {

        System.out.println(
                "Paid BDT " + amount +
                        " successfully via Rocket API.");
    }
}
