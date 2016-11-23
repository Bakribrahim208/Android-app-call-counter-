package com.example.usersfiles.contact_project.Models;

/**
 * Created by UsersFiles on 10/6/2016.
 */
public class MainData {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
     private String name, phone, income, outcome;

    public MainData(String name, String phone, String income, String outcome) {
        setName(name);

        setPhone(phone);
        setOutcome(outcome);
        setIncome(income);

    }
}
