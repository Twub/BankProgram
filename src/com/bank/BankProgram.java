package com.bank;

import com.bank.Objects.BankAccount;
import com.bank.Utility.Factory;

import java.util.ArrayList;
import java.util.Scanner;

public class BankProgram {

    private static BankProgram instance = null; // SINGLETON Can only create one instance of this class
    private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>(); // stores all accounts.
    private boolean isRunning = true;

    // private constructor for this class, so that you cant create multiple instances of this class
    // you need to get the only instance from the getInstance() method.
    private BankProgram(){

    }

    // This run method runs the whole application.
    public void run(){
        Scanner input = new Scanner(System.in);
        while (isRunning){
            MenuItem menuChoice = showAndGetMenuChoice(input);
            switch (menuChoice) {
                case SHOW_ALL_ACCOUNTS:
                    showAllAccounts();
                    break;
                case SELECT_ACCOUNT:
                    selectAccount();
                    break;
                case CREATE_ACCOUNT:
                    createAccount(input);
                    break;
            }
        }
    }

    private void showAllAccounts(){
        for (int i = 0; i < accounts.size(); i++){
            String firstName = accounts.get(i).getFirstName();
            String lastName = accounts.get(i).getLastName();
            System.out.println((i+1) + ": " + firstName + " " + lastName);
        }
    }

    private void selectAccount(){
        showAllAccounts();
        
    }

    private void createAccount(Scanner input){
        System.out.println("Type in first name");
        String firstName = input.nextLine();
        System.out.println("Type in last name");
        String lastName = input.nextLine();
        System.out.println("Type in accountBalance");
        double balance = input.nextDouble();
        BankAccount account = Factory.createBankAccount(firstName, lastName, balance);
        accounts.add(account);
    }

    // prints the menu and get a menu choice in return
    private MenuItem showAndGetMenuChoice(Scanner input){
        System.out.println("1. Show all accounts");
        System.out.println("2. Select account");
        System.out.println("3. Exit Program");

        int menuInput = input.nextInt();
        switch (menuInput){
            case 1:
                return MenuItem.SHOW_ALL_ACCOUNTS;
            case 2:
                return MenuItem.SELECT_ACCOUNT;
            case 3:
                return MenuItem.CREATE_ACCOUNT;
            case 4:
                return MenuItem.EXIT_PROGRAM;
                default:
                    System.out.println("Make a choice.");
        }
        return null;
    }

    // get the instance of this class
    public static BankProgram getInstance() {
        if (instance == null){
            instance = new BankProgram();
        }
        return instance;
    }
}
