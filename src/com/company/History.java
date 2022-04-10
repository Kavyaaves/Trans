package com.company;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

public class History {
    int type;
    float balance;
    String dateAndTime;
    float deposit;
    float withdraw;

    public void setNow(){
        Date currentDate = new Date();
        String dateToStr = DateFormat.getInstance().format(currentDate);
        this.dateAndTime = dateToStr;
    }
    public String getDate() {
        return this.dateAndTime;
    }
    public void setBalance(float amt) {
        this.balance = amt;
    }
    public float getBalance() {
        return this.balance;
    }
    public void setDeposit(float amt) {
        this.deposit = amt;
    }
    public float getDeposit() {
        return this.deposit;
    }
    public void setWithdraw(float amt) {
        this.withdraw = amt;
    }
    public float getWithdraw() {
        return this.withdraw;
    }
}

