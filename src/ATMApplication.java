import models.Account;

//This class will start the program running, it calls other classes.
public class ATMApplication {
    private static boolean isRunning = true;
    private static ScreenController screen = ScreenController.HomeScreen;
    private static Account account = null;

    public static void main(String[] args) {
        while (isRunning) {
            switch (screen) {
                case HomeScreen -> HomeScreen.run();
                case AuthenticationScreen -> AuthenticationScreen.run();
                case AccountScreen -> AccountScreen.run();
                case BalanceScreen -> BalanceScreen.run();
                case DepositScreen -> DepositScreen.run();
                case WithdrawScreen -> WithdrawScreen.run();
                default -> endProgram();
            }
        }

    }

    public static void endProgram() {
        isRunning = false;
    }

    public static void changeScreen(ScreenController nextScreen) {
        screen = nextScreen;
    }

    public static void setAccount(Account newAccount) {
        account = newAccount;
    }

    public static Account getAccount() {
        return account;
    }

    public static void clearAccount() {
        account = null;
    }
}