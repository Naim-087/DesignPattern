package structural.adapter;

interface PaymentGateway {
    void pay(double amount);
}

class BkashAPI {
    public void makePayment(double amount) {
        System.out.println("Bkash paid: " + amount);
    }
}

class RocketAPI {
    public void sendMoney(double amount) {
        System.out.println("Rocket paid: " + amount);
    }
}

class BkashAdapter implements PaymentGateway {
    private BkashAPI bkash;

    public BkashAdapter(BkashAPI bkash) {
        this.bkash = bkash;
    }

    public void pay(double amount) {
        bkash.makePayment(amount);
    }
}

class RocketAdapter implements PaymentGateway {
    private RocketAPI rocket;

    public RocketAdapter(RocketAPI rocket) {
        this.rocket = rocket;
    }

    public void pay(double amount) {
        rocket.sendMoney(amount);
    }
}

public class adapter1 {
    public static void main(String[] args) {
        PaymentGateway p1 = new BkashAdapter(new BkashAPI());
        PaymentGateway p2 = new RocketAdapter(new RocketAPI());
        p1.pay(500);
        p2.pay(300);
    }
}