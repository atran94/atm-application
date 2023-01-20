import inf.database.Repository;
import models.Account;

import java.util.Scanner;

public class DepositScreen {

    public static void run() {

        Account account = ATMApplication.getAccount();

        System.out.print("\nPlease enter the amount to deposit: $");

        Scanner scanner = new Scanner(System.in);
        String depositAmount = scanner.nextLine();

        double amount;

        try {
            amount = Double.parseDouble(depositAmount);
        } catch (NumberFormatException exception) {
            System.out.println("\nYou have entered an invalid amount.");
            amount = 0.00;
        }

        double previousBalance = account.accountBalance;

        account.accountBalance += amount;

        System.out.println();
        System.out.println("Previous Balance: $" + String.format("%,.2f", previousBalance));
        System.out.println("Deposit Amount: $" + String.format("%,.2f", amount));
        System.out.println("New Account Balance: $" + String.format("%,.2f", account.accountBalance));
        System.out.println();

        // Save to the database
        ATMApplication.setAccount(account);
        Repository.getInstance().updateAccountData(account);

        System.out.println("Do you want to make another deposit?");
        System.out.println("1. YES");
        System.out.println("2. NO");
        System.out.print("\nSelection: ");

        String selection = scanner.nextLine();

        switch (selection) {
            case "1" -> {
                ATMApplication.changeScreen(ScreenController.DepositScreen);
            }
            case "2" -> {
                ATMApplication.changeScreen(ScreenController.AccountScreen);
            }
            default -> {
                System.out.println("Invalid input, enter 1 or 2.");
                System.out.println("\n");
                ATMApplication.changeScreen(ScreenController.AccountScreen);
            }
        }
        scanner.close();
    }
}
