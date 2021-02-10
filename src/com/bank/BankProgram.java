package com.bank;

public class BankProgram {

    private static BankProgram instance = null; // SINGLETON Can only create one instance of this class

    private BankProgram(){

    }

    public void run(){

    }

    // get the instance of this class
    public static BankProgram getInstance() {
        if (instance == null){
            instance = new BankProgram();
        }
        return instance;
    }
}
