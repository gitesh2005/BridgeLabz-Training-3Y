// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " | New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + " | Remaining Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    // Abstract method
    public abstract double calculateInterest();

    // Getters and Setters (Encapsulation)
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}

// Interface Loanable
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04;  // 4% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Loan of " + amount + " applied.");
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000; // eligible if balance >= 10k
    }
}

// CurrentAccount subclass
class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.02;  // 2% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan of " + amount + " applied.");
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 50000; // eligible if balance >= 50k
    }
}

// Main class
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("SAV001", "Alice", 15000);
        BankAccount acc2 = new CurrentAccount("CUR002", "Bob", 60000);

        BankAccount[] accounts = { acc1, acc2 };

        for (BankAccount acc : accounts) {
            System.out.println("Account Number: " + acc.getAccountNumber());
            System.out.println("Holder: " + acc.getHolderName());
            System.out.println("Balance: " + acc.getBalance());
            System.out.println("Interest: " + acc.calculateInterest());

            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                System.out.println("Eligible for Loan: " + loanAcc.calculateLoanEligibility());
                loanAcc.applyForLoan(20000);
            }
            System.out.println("-------------------------");
        }
    }
}
