public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountHolderName, String accountNumber, double balance, double interestRate) {
        super(accountHolderName, accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Deposited " + amount + " to Savings Account.");
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > getBalance()) {
            throw new InsufficientBalanceException("Insufficient balance in Savings Account!");
        }
        setBalance(getBalance() - amount);
        System.out.println("Withdrew " + amount + " from Savings Account.");
    }

    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        setBalance(getBalance() + interest);
        System.out.println("Interest of " + interest + " added to Savings Account.");
    }

    @Override
    public void display() {
        System.out.println("Savings Account - " + getAccountNumber() + ", Balance: " + getBalance());
    }
}
