
class Account {
    long accountNumber;
    double balance;

    // constructor
    Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

// Child Class 1
class SavingsAccount extends Account {
    double interestRate = 5.0;

    SavingsAccount(long accNo, double bal) {
        super(accNo, bal);
    }

    void addInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }
}

// Child Class 2
class CurrentAccount extends Account {
    double overdraftLimit = 1000;

    CurrentAccount(long accNo, double bal) {
        super(accNo, bal);
    }

    void overdraft(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("Overdraft used: " + amount);
        } else {
            System.out.println("Overdraft limit exceeded");
        }
    }
}

// Main Class
public class BankApp {
    public static void main(String[] args) {

        // Savings Account
        SavingsAccount s = new SavingsAccount(101, 5000);
        s.deposit(1000);
        s.addInterest();
        s.display();

        System.out.println("------------------");

        // Current Account
        CurrentAccount c = new CurrentAccount(202, 2000);
        c.withdraw(500);
        c.overdraft(2500);
        c.display();
    }
}

}
