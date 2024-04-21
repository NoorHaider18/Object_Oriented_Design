/**
 * A java programme to demonstrate Liskov Substitution Principle
 * @author Noor Haider Khan; Student ID: 220218
 * @version 1.0
 * @since 21-04-2024 
 */

/**
 * Base class representing a bank account.
 */
class BankAccount {
    protected double balance;

    /**
     * Constructs a BankAccount object with the specified initial balance.
     * @param balance The initial balance of the account.
     */
    public BankAccount(double balance) {
        this.balance = balance;
    }

    /**
     * Retrieves the current balance of the account.
     * @return The current balance of the account.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposits the specified amount into the account.
     * @param amount The amount to deposit.
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Withdraws the specified amount from the account.
     * @param amount The amount to withdraw.
     */
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }
}

/**
 * Subclass representing a savings account.
 */
class SavingsAccount extends BankAccount {
    /**
     * Constructs a SavingsAccount object with the specified initial balance.
     * @param balance The initial balance of the account.
     */
    public SavingsAccount(double balance) {
        super(balance);
    }

    // Additional methods specific to savings account can be added here
}

/**
 * Subclass representing a checking account.
 */
class CheckingAccount extends BankAccount {
    /**
     * Constructs a CheckingAccount object with the specified initial balance.
     * @param balance The initial balance of the account.
     */
    public CheckingAccount(double balance) {
        super(balance);
    }

    // Additional methods specific to checking account can be added here
}

/**
 * Client code demonstrating the Liskov Substitution Principle.
 */
public class Liskov_Substitution_Principle {
    public static void main(String[] args) {
        // Creating a savings account
        BankAccount savingsAccount = new SavingsAccount(1000);
        System.out.println("Savings account balance: " + savingsAccount.getBalance()); // Output: 1000.0

        // Creating a checking account
        BankAccount checkingAccount = new CheckingAccount(2000);
        System.out.println("Checking account balance: " + checkingAccount.getBalance()); // Output: 2000.0
    }
}
