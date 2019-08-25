package com.michaelkatan.debtrecord.models;


import java.util.UUID;

public class Debt
{
    private String debtId;
    private String personA;
    private String personB;
    private int amount;

    //Constructors
    public Debt(){}
    public Debt(String personA, String personB, int amount) {
        this.personA = personA;
        this.personB = personB;
        this.amount = amount;
        this.debtId = UUID.randomUUID().toString();
    }

    //Setters-Getters

    public String getDebtId() {
        return debtId;
    }
    public void setDebtId(String debtId) {
        this.debtId = debtId;
    }
    public String getPersonA() {
        return personA;
    }
    public void setPersonA(String personA) {
        this.personA = personA;
    }
    public String getPersonB() {
        return personB;
    }
    public void setPersonB(String personB) {
        this.personB = personB;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }


}
