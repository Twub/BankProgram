package com.bank.Utility;

import com.bank.Objects.BankAccount;

public abstract class Factory {

    // A List of Object the user can create.
    public enum creationType {
        BANK_ACCOUNT,
    }

    public static BankAccount createBankAccount(String firstName, String lastName, double startBalance){
        return new BankAccount(firstName, lastName, startBalance);
    }

}
