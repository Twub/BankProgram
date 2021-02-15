package com.bank;

import com.bank.Objects.BankAccount;
import com.bank.Utility.Factory;

import java.util.ArrayList;
import java.util.Scanner;

public class BankProgram {

    private static BankProgram instance = null; // SINGLETON Can only create one instance of this class
    private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>(); // stores all accounts.
    private boolean isRunning = true;
    private ArrayList<String> transactions = new ArrayList<String>();

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
                    selectAccount(input);
                    break;
                case CREATE_ACCOUNT:
                    createAccount(input);
                    break;
                case EXIT_PROGRAM:
                    isRunning = !isRunning;
                    break;
            }
        }
    }

    public void start(){

    }

    // create account
    private void AC(int accountNumber, String accountHolderFirstname, double startBalance){
        if (isExisting(accountNumber)){
            System.out.println("Konto finns redan: " + accountNumber);
        }else {
            BankAccount account = new BankAccount(accountNumber, accountHolderFirstname, startBalance);
            account.addTransaction("NY" + accountNumber + "" + startBalance);
            accounts.add(account);
        }
    }

    // put in money
    private void IN(int accountNumber, double balance){
        BankAccount account = null;
        for (int i = 0; i < accounts.size(); i++){
            if (accounts.get(i).getAccountNumber() == accountNumber){
                account = accounts.get(i);
            }
        }
        if (account == null){
            System.out.println("Kontonummer: " + accountNumber + " saknas");
            return;
        }
        double oldBalance = account.getAccountBalance();
        account.addMoney(balance);
        System.out.println("Saldo: " + oldBalance + " Belopp: " + balance + " Nytt saldo: " + account.getAccountBalance());
        account.addTransaction("IN" + balance);
    }

    // take out money
    private void UT(int accountNumber, double balance){
        BankAccount account = null;
        for (int i = 0; i < accounts.size(); i++){
            if (accounts.get(i).getAccountNumber() == accountNumber){
                account = accounts.get(i);
            }
        }
        if (account == null){
            System.out.println("Kontonummer: " + accountNumber + " saknas");
            return;
        }
        if (account.getAccountBalance() >= balance){
            double oldBalance = account.getAccountBalance();
            System.out.println("Saldo: " + oldBalance + " Belopp: " + balance + " Nytt saldo: " + account.getAccountBalance());
            account.addTransaction("UT" + balance);
        }else {
            System.out.println("MEDGES EJ (" + account.getAccountBalance() + ", " + balance + ")");
        }
    }

    // transaction list
    private void AB(int accountNumber){
        BankAccount account = null;
        for (int i = 0; i < accounts.size(); i++){
            if (accounts.get(i).getAccountNumber() == accountNumber){
                account = accounts.get(i);
            }
        }
        if (account == null){
            System.out.println("Kontonummer: " + accountNumber + " saknas");
            return;
        }
        ArrayList<String> transactions = account.getTransactions();
        for (String transaction : transactions){
            System.out.println(transaction);
        }
    }

    private void NS(){
        for (BankAccount account : accounts){
            System.out.println("Innehavare: " + account.getFirstName() + ". Saldo: " + account.getAccountBalance());
        }
    }

    // check if account number already exist.
    private boolean isExisting(int accountNumber){
        for (int i = 0; i < accounts.size(); i++){
            if (accounts.get(i).getAccountNumber() == accountNumber){
                return true;
            }
        }
        return false;
    }

    private void showAllAccounts(){
        for (int i = 0; i < accounts.size(); i++){
            String firstName = accounts.get(i).getFirstName();
            String lastName = accounts.get(i).getLastName();
            System.out.println((i+1) + ": " + firstName + " " + lastName);
        }
        System.out.println("");
    }

    private void selectAccount(Scanner input){
        showAllAccounts();
        int selectedAccount = input.nextInt() - 1;
        System.out.println("1. Take out money");
        System.out.println("2. Put in money");
        System.out.println("3. Show balance.");
        System.out.println("4. Show transactions");

        int menuChoice = input.nextInt();

        switch (menuChoice){
            case 1:
                System.out.println("How much money do you want to take out?");
                double takeout = input.nextDouble();
                boolean success = accounts.get(selectedAccount).takeOut(takeout);
                if (success){
                    System.out.println("Success you took out: " + takeout);
                }else {
                    System.out.println("You have not enough money on your account.");
                }
                break;
            case 2:
                System.out.println("How much do you want to put in?");
                double prev = accounts.get(selectedAccount).getAccountBalance();
                double money = input.nextDouble();
                accounts.get(selectedAccount).addMoney(money);
                System.out.println("Before: " + prev + " : After: " + accounts.get(selectedAccount).getAccountBalance());
                break;
            case 3:
                System.out.println("Current balance is: " + accounts.get(selectedAccount).getAccountBalance());
                break;
            case 4:
                ArrayList<String> transactions = accounts.get(selectedAccount).getTransactions();
                for (int i = 0; i < transactions.size(); i++){
                    System.out.println((i+1) + ": " + transactions.get(i));
                }
                break;
        }
    }

    private void createAccount(Scanner input){
        System.out.println("Type in first name");
        String firstName = input.next();
        System.out.println("Type in last name");
        String lastName = input.next();
        System.out.println("Type in accountBalance");
        double balance = input.nextDouble();
        BankAccount account = Factory.createBankAccount(firstName, lastName, balance);
        accounts.add(account);
    }

    // prints the menu and get a menu choice in return
    private MenuItem showAndGetMenuChoice(Scanner input){
        System.out.println("1. Show all accounts");
        System.out.println("2. Select account");
        System.out.println("3. Create bank account");
        System.out.println("4. Exit Program");

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
