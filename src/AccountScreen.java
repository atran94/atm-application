import models.Account;

import java.util.Scanner;

public class AccountScreen {
    public static void run() {

        Account account = ATMApplication.getAccount();

        System.out.println("\nWelcome " + account.userName + ",");
        System.out.println();
        System.out.println("Enter the number of action you would like to take:");
        System.out.println();
        System.out.println("1. Check the account balance");
        System.out.println("2. Make a deposit");
        System.out.println("3. Withdraw from the account");
        System.out.println("4. Logout of account");
        System.out.print("\nSelection: ");

        Scanner scanner = new Scanner(System.in);
        String selection = scanner.nextLine();
        scanner.close();

        switch (selection) {
            case "1" -> {
                // Send user to balance screen
                ATMApplication.changeScreen(ScreenController.BalanceScreen);
            }
            case "2" -> {
                // Send user to the deposit screen
                ATMApplication.changeScreen(ScreenController.DepositScreen);
            }
            case "3" -> {
                // Send user to the withdraw screen
                ATMApplication.changeScreen(ScreenController.WithdrawScreen);
            }
            case "4" -> {
                // Exiting the application
                System.out.println("\nThank you for your business.");
                System.out.println("Have a great day!");
                System.out.println("\n");

                // log out of account will clear the account and send user to the home screen
                ATMApplication.clearAccount();
                ATMApplication.changeScreen(ScreenController.HomeScreen);
            }
            default -> {
                System.out.println("Invalid input, enter 1, 2, 3 or 4.");
                System.out.println("\n");
                ATMApplication.changeScreen(ScreenController.AccountScreen);
            }
        }
    }
}
