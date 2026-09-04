import java.util.ArrayList;

class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactions;

    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount + " | Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew: " + amount + " | Balance: " + balance);
        } else {
            transactions.add("Failed withdrawal: " + amount + " | Balance: " + balance);
        }
    }

    public void printTransactions() {
        System.out.println("Transaction history for " + accountHolder + ":");
        for (String t : transactions) {
            System.out.println(t);
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        Account acc = new Account("Doron", 1000);

        acc.deposit(500);
        acc.withdraw(200);
        acc.withdraw(2000); // should fail

        System.out.println("Final Balance: " + acc.getBalance());
        acc.printTransactions();
    }
}

