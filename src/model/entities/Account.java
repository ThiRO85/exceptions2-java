package model.entities;

import model.exceptions.DomainException;

public class Account {

    private Integer number;
    private String name;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String name, Double balance, Double withdrawLimit) throws DomainException {
        if (balance <= 0.0) {
            throw new DomainException("Not enough balance");
        }
        this.number = number;
        this.name = name;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
       return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws DomainException {
        if (balance <= 0.0) {
            throw new DomainException("Not enough balance");
        }
        if (amount > withdrawLimit) {
            throw new DomainException("The amount exceeds withdraw limit");
        }
        else {
            this.balance -= amount;
        }
    }

}
