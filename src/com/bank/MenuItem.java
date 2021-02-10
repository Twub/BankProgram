package com.bank;

public enum MenuItem {

    SHOW_ALL_ACCOUNTS("1. Show all accounts"),
    SELECT_ACCOUNT("2. Select account"),
    CREATE_ACCOUNT("3. Create new bank account"),
    EXIT_PROGRAM("4. Exit Program");


    public String description;

    MenuItem(String description){
        this.description = description;
    }
}
