
package prerequisities.object_and_classes;

public class Bank_Account_Class {

    private String accountHolder;
    private String accountNumber;
    private double balance;

    // Constructor
    public Bank_Account_Class(
            String accountHolder,
            String accountNumber,
            double initialBalance) {

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit money
    public void depositMoney(double amount) {

        if (amount < 500) {
            System.out.println(
                    "Invalid deposit amount. Minimum deposit is 500 Tk.");
            return;
        }

        balance += amount;
        System.out.println("Deposit successful: Tk " + amount);
    }

    // Withdraw money
    public void withdrawMoney(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful: Tk " + amount);
        }
    }

    // Display account information
    public void displayAccountInfo() {

        System.out.println("\n------ Account Information ------");
        System.out.println("Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Balance: Tk %.2f%n", balance);
    }
}

// Main must be outside Bank_Account_Class
class Main {

    public static void main(String[] args) {

        Bank_Account_Class account1 = new Bank_Account_Class(
                "Naim Islam",
                "ACC-1002",
                30000.00);

        Bank_Account_Class account2 = new Bank_Account_Class(
                "Arif Islam",
                "ACC-3004",
                400000.00);

        account1.depositMoney(15000.00);
        account2.withdrawMoney(7000.00);

        account1.displayAccountInfo();
        account2.displayAccountInfo();
    }
}
