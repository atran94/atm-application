package inf.file;

import com.google.gson.Gson;
import models.Account;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * This class is created to read/write data to the text file
 */
public class FileHandler {
    // Create a private constant variable for the current directory
    private static final String FILE_DIRECTORY = System.getProperty("user.dir") + System.getProperty("file.separator") + "Accounts";

    // Create the private variable for the suffix of the file
    private static final String FILE_SUFFIX = ".txt";

    // Create a method to read the file which contains the account number
    public static Account readFile(long accountNumber) {
        createAccountsDirectory();

        String fileName = getFileName(accountNumber);
        // Use StringBuilder to save the data that we read from the file
        StringBuilder data = new StringBuilder();

        try {
            File file = new File(fileName);
            if (!file.exists()) {
                //System.err.println("File '" + fileName + "' does not exist");
                return null;
            }

            // Use Scanner to read the file line by line
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data.append(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // Use Gson to serialize the string from Json to the Account object
        return new Gson().fromJson(data.toString(), Account.class);
    }

    // This method will write data to the file
    public static boolean writeFile(Account account) {
        createAccountsDirectory();

        String fileName = getFileName(account.accountNumber);

        try {
            File file = new File(fileName);
            // Use the File library to write to the file if it exists
            // If the file does not exist, create it, and write to it
            file.createNewFile();

            // Use Gson to deserialize the Account object into Json string
            String data = new Gson().toJson(account);

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    /**
     * This method will construct the fileName with correct directory and file extension
     * @param accountNumber
     * @return
     */
    private static String getFileName(long accountNumber) {
        return FILE_DIRECTORY + System.getProperty("file.separator") + accountNumber + FILE_SUFFIX;
    }

    /**
     * This method will create the directory if it does not exist.
     */
    private static void createAccountsDirectory() {
        try {
            Files.createDirectories(Paths.get(FILE_DIRECTORY));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
