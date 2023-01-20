package inf.database;

import models.Account;

import java.sql.*;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class DatabaseSQL implements DatabaseAPI {
    private static DatabaseSQL INSTANCE = null;

    private static final String SQL_URL = "jdbc:sqlserver://";
    private static final String HOST = "192.168.1.121";
    private static final String PORT = "1433";
    private static final String DATABASE = "TestDB";
    private static final String USERNAME = "atran";
    private static final String PASSWORD = "Pepper1006";
    private static final String ACCOUNTS_TBL = "Accounts";

    private String getConnectionURL() {
        return SQL_URL + HOST + ":" + PORT + ";"
                + "database=" + DATABASE + ";"
                + "user=" + USERNAME + ";"
                + "password=" + PASSWORD + ";"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";
    }

    public static DatabaseSQL getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseSQL();
        }

        return INSTANCE;
    }

    private DatabaseSQL() {
        // no-op
    }

    @Override
    public boolean findAccount(long accountNumber) {
        String selectSql = "SELECT * " +
                "FROM " + ACCOUNTS_TBL + " " +
                "WHERE AccountNumber = " + accountNumber;

        try {
            // connect to DB
            Connection connection = DriverManager.getConnection(getConnectionURL());

            // prepare the sql query
            Statement statement = connection.createStatement();

            // execute the sql query and store the results
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                long resultAccountNumber = resultSet.getInt("AccountNumber");

                if (resultAccountNumber == accountNumber) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Account getAccountData(long accountNumber, int pinNumber) {
        String selectSql = "SELECT * " +
                "FROM " + ACCOUNTS_TBL + " " +
                "WHERE AccountNumber = " + accountNumber + " " +
                "AND PinNumber = " + pinNumber;

        try {
            // connect to DB
            Connection connection = DriverManager.getConnection(getConnectionURL());

            // prepare the sql query
            Statement statement = connection.createStatement();

            // execute the sql query and store the results
            ResultSet resultSet = statement.executeQuery(selectSql);

            // was a result found or not?
            while (resultSet.next()) {
                if (accountNumber == resultSet.getInt("AccountNumber")
                        && pinNumber == resultSet.getInt("PinNumber")) {
                    Account account = new Account();
                    account.accountNumber = resultSet.getInt("AccountNumber");
                    account.userName = resultSet.getString("UserName");
                    account.pinNumber = resultSet.getInt("PinNumber");
                    account.accountBalance = resultSet.getBigDecimal("AccountBalance").doubleValue();

                    return account;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public boolean updateAccountData(Account account) {
        String updateSql = "UPDATE " + ACCOUNTS_TBL + " " +
                "SET UserName = '" + account.userName + "', " +
                "AccountBalance = " + account.accountBalance + " " +
                "WHERE AccountNumber = " + account.accountNumber + " " +
                "AND PinNumber = " + account.pinNumber;

        try {
            // connect to DB
            Connection connection = DriverManager.getConnection(getConnectionURL());

            // prepare the sql query
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql, RETURN_GENERATED_KEYS);

            // execute
            int updatedRows = preparedStatement.executeUpdate();

            // returns true if the updatedRows > 0, and false if 0 (no rows updated)
            return updatedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
