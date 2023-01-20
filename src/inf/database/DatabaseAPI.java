package inf.database;

import models.Account;

/**
 * This interface will create a contract between the database and user
 * it allows the user to find account, get account data, update account
 */
public interface DatabaseAPI {
    /**
     * This method will find the account given the accountNumber.
     *
     * @param accountNumber long
     * @return True if account found, False if not
     */
    boolean findAccount(long accountNumber);

    /**
     * This method will take the accountNumber and pinNumber and return the Account object
     *
     * @param accountNumber long
     * @param pinNumber     int
     * @return Account
     */
    Account getAccountData(long accountNumber, int pinNumber);

    /**
     * This method will update the account data
     *
     * @param account Account
     * @return True if the account is updated, false if not
     */
    boolean updateAccountData(Account account);
}
