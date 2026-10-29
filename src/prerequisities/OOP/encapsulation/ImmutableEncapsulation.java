package prerequisities.OOP.encapsulation;
/*
Scenario: Immutable Bank Transaction
A banking application needs to store transaction records. Once a transaction is created, its transaction ID, amount, and transaction type must never change. This ensures that transaction records remain consistent and cannot be modified accidentally.

Requirements:
- All attributes must be private and final.
- Values must be initialized through a constructor.
- No setter methods are allowed.
- Getter methods provide read-only access.
- A displayInformation() method displays all transaction details.
*/

/*
Immutable encapsulation is a modern object-oriented design practice where an object’s state is bundled 
and completely locked down from modification after instantiation. Instead of protecting data by 
providing controlled write access through setters and validation logic, an immutable object enforces data integrity by 
ensuring it can never change at all once created.
*/

final class Immutable_Transaction {

    private final String txnID;
    private final double amount;
    private final String txnType;

    // Constructor

    Immutable_Transaction(String txnID, double amount, String txnType) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        this.txnID = txnID;
        this.amount = amount;
        this.txnType = txnType;

    }

    // Getter Method
    public String getTransactionId() {
        return txnID;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return txnType;
    }

    //// Display transaction information
    public void displayInformation() {
        System.out.println("Transaction Information");
        System.out.println("-----------------------");
        System.out.println("Transaction ID: " + txnID);
        System.out.println("Amount: $" + amount);
        System.out.println("Transaction Type: " + txnType);
    }

}

public class ImmutableEncapsulation {

    public static void main(String[] args) {
        Immutable_Transaction txn1 = new Immutable_Transaction("TXN-1001", 45000.00, "Withdraw");

        Immutable_Transaction txn2 = new Immutable_Transaction("TXN-1004", 53000.00, "Transfer");

        txn1.displayInformation();
        txn2.displayInformation();

        // Access Individual attributes

        System.out.println("\nTransaction Amount: $" + txn1.getAmount());
    }

}
