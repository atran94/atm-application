package inf.database;

import inf.file.FileHandler;
import models.Account;

public class DatabaseFileSystem implements DatabaseAPI {
    private static DatabaseFileSystem INSTANCE = null;

    /**
     * the getInstance() ensures that we only ever have one instance of the database running at any time,
     * this is a singleton.
     */
    public static DatabaseFileSystem getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseFileSystem();
        }

        return INSTANCE;
    }

    /**
     * This constructor is made private to enable the singleton pattern and force the use of getInstance()
     */
    private DatabaseFileSystem() {
        // no-op
    }

    @Override
    public boolean findAccount(long accountNumber) {
        Account account = FileHandler.readFile(accountNumber);
        return account != null;
    }

    @Override
    public Account getAccountData(long accountNumber, int pinNumber) {
        Account account = FileHandler.readFile(accountNumber);

        if (account != null && account.pinNumber == pinNumber) {
            return account;
        }

        return null;
    }

    @Override
    public boolean updateAccountData(Account account) {
        return FileHandler.writeFile(account);
    }
}
