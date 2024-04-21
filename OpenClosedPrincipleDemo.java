/**
 * A java programme to demonstrate Open Closed Principle
 * @author Noor Haider Khan; Student ID: 220218
 * @version 1.0
 * @since 21-04-2024 
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Interface representing a bank account.
 */
interface BankAccount {
    /**
     * Deposits the specified amount into the account.
     * @param amount The amount to deposit.
     */
    void deposit(double amount);

    /**
     * Withdraws the specified amount from the account.
     * @param amount The amount to withdraw.
     */
    void withdraw(double amount);

    /**
     * Retrieves the current balance of the account.
     * @return The current balance of the account.
     */
    double getBalance();
}

/**
 * Concrete implementation for savings account.
 */
class SavingsAccount implements BankAccount {
    private double balance;

    /**
     * Constructs a SavingsAccount object with the specified initial balance.
     * @param initialBalance The initial balance of the account.
     */
    public SavingsAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

/**
 * Concrete implementation for checking account.
 */
class CheckingAccount implements BankAccount {
    private double balance;

    /**
     * Constructs a CheckingAccount object with the specified initial balance.
     * @param initialBalance The initial balance of the account.
     */
    public CheckingAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

/**
 * Bank class that manages different types of accounts.
 */
class Bank {
    private List<BankAccount> accounts;

    /**
     * Constructs a Bank object with an empty list of accounts.
     */
    public Bank() {
        this.accounts = new ArrayList<>();
    }

    /**
     * Adds a bank account to the bank.
     * @param account The bank account to add.
     */
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    /**
     * Displays the balances of all accounts in the bank.
     */
    public void displayAllBalances() {
        System.out.println("Account Balances:");
        for (BankAccount account : accounts) {
            System.out.println(account.getClass().getSimpleName() + ": $" + account.getBalance());
        }
    }
}

/**
 * Demo class demonstrating the usage of different types of bank accounts.
 */
public class OpenClosedPrincipleDemo {
    public static void main(String[] args) {
        // Create bank
        Bank bank = new Bank();

        // Add different types of accounts
        bank.addAccount(new SavingsAccount(1000));
        bank.addAccount(new CheckingAccount(2000));

        // Display balances of all accounts
        bank.displayAllBalances();

        // Adding a new type of account (without modifying existing code)
        // For example, adding a Money Market account
        bank.addAccount(new BankAccount() {
            private double balance = 3000;

            @Override
            public void deposit(double amount) {
                balance += amount;
            }

            @Override
            public void withdraw(double amount) {
                if (amount <= balance) {
                    balance -= amount;
                } else {
                    System.out.println("Insufficient funds!");
                }
            }

            @Override
            public double getBalance() {
                return balance;
            }
        });

        // Display balances of all accounts including the newly added Money Market account
        bank.displayAllBalances();
    }
}

