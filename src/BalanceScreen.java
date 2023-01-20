import models.Account;

import java.util.Scanner;

public class BalanceScreen {

    public static void run() {
        Account account = ATMApplication.getAccount();

        System.out.println("Your account balance is: ");
        System.out.println();
        System.out.println("$" + String.format("%,.2f", account.accountBalance));
        System.out.println();
        System.out.println("Press Enter to return the Account Screen.");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();

        ATMApplication.changeScreen(ScreenController.AccountScreen);
    }
}
