package com.jsp.pin;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void increaseBalance(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void decreaseBalance(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}

