import inf.database.Repository;
import models.Account;

import java.util.Scanner;

public class AuthenticationScreen {
    public static void run() {
        // Prompt the user to enter 16-digit account number
        System.out.println("Please enter your account number: ");

        // listen for the user input and store it into a variable. (It'll be in string format)
        Scanner scanner = new Scanner(System.in);
        String accountNumber = scanner.nextLine();

        // Use the database and find the account with that accountNumber. (convert the variable to int)
        // - if we don't find it, then loop back to the beginning, let the user know we couldn't find it.
        // - if we do find it, then ask the user for the pinNumber (4-digit)
        boolean isAccountFound = Repository.getInstance().findAccount(Long.parseLong(accountNumber));
        if (!isAccountFound) {
            System.out.println("Account not found!");
            ATMApplication.changeScreen(ScreenController.AuthenticationScreen);
        } else {
            System.out.println("Please enter your pin number: ");
            // listen for the user input and store it into a new variable (It'll be in string format)
            String pinNumber = scanner.nextLine();

            // use the database to get the account with the accountNumber and pinNumber (convert variable to int as well)
            // -if we have an Account object returned, then navigate from AuthenticationScreen to AccountScreen
            // -if we don't have an account (our return value is null) then let the  user know the pin was incorrect and
            //      loop back to the beginning.
            Account account = Repository.getInstance().getAccountData(
                    Long.parseLong(accountNumber),
                    Integer.parseInt(pinNumber)
            );
            if (account == null) {
                System.out.println("Incorrect PIN!");
                ATMApplication.changeScreen(ScreenController.AuthenticationScreen);
            } else {
                ATMApplication.setAccount(account);
                ATMApplication.changeScreen(ScreenController.AccountScreen);
            }
        }
        scanner.close();
    }
}
