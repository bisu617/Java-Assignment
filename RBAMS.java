import java.util.Scanner;

public class RBAMS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Rural Bank of Nepal");
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        Customer customer = new Customer(name);

        SavingsAccount savings = new SavingsAccount(name, "SAV123", 5000, 5.0);
        CurrentAccount current = new CurrentAccount(name, "CUR123", 2000, 1000);
        customer.addAccount(savings);
        customer.addAccount(current);

        int choice;
        do {
            System.out.println("\nChoose operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Add Interest (Savings)");
            System.out.println("4. View Accounts");
            System.out.println("5. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                case 2:
                    System.out.print("Select account (1: Savings, 2: Current): ");
                    int accChoice = scanner.nextInt();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();

                    try {
                        if (accChoice == 1) {
                            if (choice == 1) savings.deposit(amount);
                            else savings.withdraw(amount);
                        } else {
                            if (choice == 1) current.deposit(amount);
                            else current.withdraw(amount);
                        }
                    } catch (InsufficientBalanceException e) {
                        System.out.println("Operation failed: " + e.getMessage());
                    }
                    break;

                case 3:
                    savings.addInterest();
                    break;

                case 4:
                    for (BankAccount acc : customer.getAccounts()) {
                        acc.display();
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using RBN. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
