package com.bank.Objects;

public class Person {

    private String firstName;
    private String lastName;

    public Person(String firstName){
        this.firstName = firstName;
        this.lastName = ".";
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }
}
