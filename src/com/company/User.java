package com.company;

public class User {
    private int accNo;
    private int pin;
    public float balance;
    public static User users[] = {new User(1001, 1234,4000), new User(1002, 1234,12000), new User(1003, 2345,25000)};

    public User(int accNo, int pin, float balance) {
        this.accNo = accNo;
        this.pin = pin;
        this.balance = balance;
    }
    float getBalance(int accNo){
        for(User u: this.users) {
            if (u.accNo == accNo)
                return u.balance;
            }
        return 0;
    }

    void setBalance(float amt){
        this.balance = amt;
    }

    User[] getUsers(){
        return this.users;
    }

    public boolean equals(User user) {
        if (this.accNo == user.accNo &&
                this.pin == user.pin) {
            return true;
        }
        return false;
    }
}
