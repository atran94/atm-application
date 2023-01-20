package inf.database;

import models.Account;

public class Repository implements DatabaseAPI {
    private static Repository INSTANCE = null;
    private final DatabaseSQL database;

    public static Repository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository();
        }

        return INSTANCE;
    }

    private Repository() {
        database = DatabaseSQL.getInstance();
    }

    @Override
    public boolean findAccount(long accountNumber) {
        return database.findAccount(accountNumber);
    }

    @Override
    public Account getAccountData(long accountNumber, int pinNumber) {
        return database.getAccountData(accountNumber, pinNumber);
    }

    @Override
    public boolean updateAccountData(Account account) {
        return database.updateAccountData(account);
    }
}
