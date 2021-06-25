package com.efrem.miu.lab2;

public class Logger {
    public void logger(String accountNumber){
        System.out.println("\nLogger Class : There is change in account number:- \t" + accountNumber );
    }
    public void logger(String fromAccountNumber, String toAccountNumber){
        System.out.printf("\nThis is message from Logger pager. There is a transfer of money from account %s to acount %s%n",fromAccountNumber,toAccountNumber);
    }
}
