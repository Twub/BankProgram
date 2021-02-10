package com.bank;

import com.bank.Objects.BankAccount;

import java.util.ArrayList;
import java.util.Scanner;

public class BankProgram {

    private static BankProgram instance = null; // SINGLETON Can only create one instance of this class
    private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

    // private constructor for this class, so that you cant create multiple instances of this class
    // you need to get the only instance from the getInstance() method.
    private BankProgram(){

    }

    // This run method runs the whole application.
    public void run(){
        Scanner input = new Scanner(System.in);
    }

    // prints the menu and get a menu choice in return
    

    // get the instance of this class
    public static BankProgram getInstance() {
        if (instance == null){
            instance = new BankProgram();
        }
        return instance;
    }
}
