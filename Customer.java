package com.efrem.miu.lab2;

public class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update(){
        System.out.printf("SMS MESSAGE :- \n \tCustomer %s, there is change in your account",name);
    }
    public void receiveEmailMessage(String message){
        System.out.println("Dear " + name + message);
    }

}