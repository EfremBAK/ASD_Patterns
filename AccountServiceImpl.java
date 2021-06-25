package com.efrem.miu.lab2;

import java.util.Collection;

public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;
    private Logger logger;

    public AccountServiceImpl(){
        accountDAO = new AccountDAOImpl();
        logger = new Logger();
    }

    public Account createAccount(String accountNumber, String customerName, String email) {
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName,email);
        account.setCustomer(customer);

        accountDAO.saveAccount(account);
        String welcome = " New account has been created with us";
        customer.receiveEmailMessage(welcome);

        return account;
    }

    public void deposit(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);

        accountDAO.updateAccount(account);
        logger.logger(accountNumber);
    }


    public Account getAccount(String accountNumber) {
        return accountDAO.loadAccount(accountNumber);

    }

    public Collection<Account> getAllAccounts() {
        return accountDAO.getAccounts();
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
        logger.logger(accountNumber);
    }



    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
        logger.logger(fromAccountNumber,toAccountNumber);
    }
}

