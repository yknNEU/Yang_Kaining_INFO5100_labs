package model;

import java.util.ArrayList;
import java.util.List;

public class AccountDirectory {

    private List<Account> accounts;

    public AccountDirectory() {
        this.accounts = new ArrayList<Account>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addAccount(String bankName, String routingNumber, String accountNumber, int balance) {
        Account account = new Account(bankName, routingNumber, accountNumber, balance);
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public Account searchAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().contains(accountNumber)) {
                return account;
            }
        }
        return null;
    }

}
