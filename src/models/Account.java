package models;

import com.google.gson.annotations.SerializedName;

/**
 * This account object will be used to serialize and deserialize the account information
 * from Database text file using Gson.
 * <p>
 * Use @SerializedName to match the Json key with the variable name
 * <p>
 * We @Override the toString() to print out all the field information.
 */
public class Account {
    @SerializedName("account_number")
    public long accountNumber;

    @SerializedName("user_name")
    public String userName;

    @SerializedName("pin")
    public int pinNumber;

    @SerializedName("account_balance")
    public double accountBalance;

    @Override
    public String toString() {
        return "Account[" +
                "accountNumber=" + accountNumber + ", " +
                "userName=" + userName + ", " +
                "pinNumber=" + pinNumber + ", " +
                "accountBalance=" + accountBalance +
                "]";
    }
}
