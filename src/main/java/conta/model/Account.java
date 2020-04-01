package main.java.conta.model;

import main.java.exception.InsufficientBalanceException;

public class Account {

    private double id;
    private double balance;
    private int agency;
    private int accountNumber;
    private String holder;

    public double getId() {
        return id;
    }

    public void deposit(double value) {
        this.balance = this.balance + value;
    }

    public boolean withdraw(double value) {
        if (this.balance >= value) {
            this.balance = this.balance - value;
            return true;
        } else {
            throw new InsufficientBalanceException("It is not possible to make the withdraw insufficient balance");
        }
    }

    public boolean transfer(double value, Account destiny) throws InsufficientBalanceException {
        if (this.balance >= value) {
            this.balance -= value;
            destiny.deposit(value);
            return true;
        } else {
            throw new InsufficientBalanceException("It is not possible to make the transfer insufficient balance");
        }
    }

    public Account(double id, double balance, int agency, int accountNumber, String holder) {
        this.id = id;
        this.balance = balance;
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.holder = holder;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", agency=" + agency +
                ", accountNumber=" + accountNumber +
                ", holder='" + holder + '\'' +
                '}';
    }
}
