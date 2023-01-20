import java.util.Scanner;

public class HomeScreen {

    //Create a method run() to display the home screen
    public static void run() {
        System.out.println("\t\t\t\tWelcome to ATC bank");
        System.out.println("\t\t\t\t We got your back");
        System.out.println("\n");
        System.out.println("\t\t\tPress Enter key to continue...");

        //This code will read any key to continue
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        //This code will change from Home Screen to AuthenticationScreen
        ATMApplication.changeScreen(ScreenController.AuthenticationScreen);
    }
}
