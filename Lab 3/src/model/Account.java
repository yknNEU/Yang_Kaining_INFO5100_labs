package model;

public class Account{

    private String bankName;
    private String routingNumber;
    private String accountNumber;
    private int balance;

    public Account(String bankName, String routingNumber, String accountNumber, int balance){
        this.bankName = bankName;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Account(){
        this.bankName = "";
        this.routingNumber = "";
        this.accountNumber = "";
        this.balance = 0;
    }

    public String getBankName(){
        return bankName;
    }

    public void setBankName(String bankName){
        this.bankName = bankName;
    }

    public String getRoutingNumber(){
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber){
        this.routingNumber = routingNumber;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public int getBalance(){
        return balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    @Override
    public String toString(){
        return this.bankName;
    }

}