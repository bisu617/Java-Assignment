public class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountHolderName, String accountNumber, double balance, double overdraftLimit) {
        super(accountHolderName, accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Deposited " + amount + " to Current Account.");
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > getBalance() + overdraftLimit) {
            throw new InsufficientBalanceException("Exceeded overdraft limit!");
        }
        setBalance(getBalance() - amount);
        System.out.println("Withdrew " + amount + " from Current Account.");
    }

    @Override
    public void display() {
        System.out.println("Current Account - " + getAccountNumber() + ", Balance: " + getBalance() + ", Overdraft Limit: " + overdraftLimit);
    }
}
