import inf.database.Repository;
import models.Account;

import java.util.Scanner;

public class WithdrawScreen {

    public static void run() {

        Account account = ATMApplication.getAccount();

        System.out.print("\n Please enter the amount to withdraw: $");

        Scanner scanner = new Scanner(System.in);
        String withdrawAmount = scanner.nextLine();

        double amount;

        try {
            amount = Double.parseDouble(withdrawAmount);
        } catch (NumberFormatException exception) {
            System.out.println("\nYou have entered an invalid amount.\n");
            amount = 0.00;
        }

        double previousBalance = account.accountBalance;

        System.out.println();

        if (amount <= previousBalance) {
            account.accountBalance = account.accountBalance - amount;
            System.out.println("Previous Balance: $" + String.format("%,.2f", previousBalance));
            System.out.println("Withdraw Amount: $" + String.format("%,.2f", amount));
            System.out.println("New Account Balance: $" + String.format("%,.2f", account.accountBalance));
            System.out.println();

            // Save to the database
            ATMApplication.setAccount(account);
            Repository.getInstance().updateAccountData(account);
        } else {
            System.out.println("There is an insufficient amount in your account.");
            System.out.println("Your current balance is: $" + String.format("%,.2f", previousBalance));
            System.out.println();
        }

        System.out.println("Do you want to make another withdraw?");
        System.out.println("1. YES");
        System.out.println("2. NO");
        System.out.print("\nSelection: ");

        String selection = scanner.nextLine();

        switch (selection) {
            case "1" -> {
                ATMApplication.changeScreen(ScreenController.WithdrawScreen);
            }
            case "2" -> {
                ATMApplication.changeScreen(ScreenController.AccountScreen);
            }
            default -> {
                System.out.println("Invalid input, enter 1 or 2\n");
                ATMApplication.changeScreen(ScreenController.AccountScreen);
            }
        }
        scanner.close();
    }
}
