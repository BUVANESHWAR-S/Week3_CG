package Day2.OOP_Concepts.pb5;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getDetails() {
        return holderName + " - " + accountNumber;
    }

    abstract double calculateInterest();
}

interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    SavingsAccount(String acc, String name, double bal) {
        super(acc, name, bal);
    }

    double calculateInterest() {
        return getBalance() * 0.04;
    }

    public boolean applyForLoan(double amount) {
        return amount <= calculateLoanEligibility();
    }

    public double calculateLoanEligibility() {
        return getBalance() * 2;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    CurrentAccount(String acc, String name, double bal) {
        super(acc, name, bal);
    }

    double calculateInterest() {
        return getBalance() * 0.02;
    }

    public boolean applyForLoan(double amount) {
        return amount <= calculateLoanEligibility();
    }

    public double calculateLoanEligibility() {
        return getBalance() * 1.5;
    }
}

public class pb5 {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("SA123", "Alice", 5000);
        BankAccount acc2 = new CurrentAccount("CA456", "Bob", 8000);

        System.out.println(acc1.getDetails() + " Interest: " + acc1.calculateInterest());
        System.out.println(acc2.getDetails() + " Interest: " + acc2.calculateInterest());
    }
}
