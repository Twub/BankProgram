package com.bank;

public enum MenuItem {

    SHOW_ALL_ACCOUNTS("1. Show all accounts"),
    SELECT_ACCOUNT("2. Select account"),
    CREATE_ACCOUNT("3. Create new bank account"),
    EXIT_PROGRAM("4. Exit Program"),
    TAKE_OUT_MONEY("1. Take out money"),
    PUT_IN_MONEY("2. Put in money");


    public String description;

    MenuItem(String description){
        this.description = description;
    }
}
