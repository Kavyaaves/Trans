package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Transactions {
    HashMap<Integer, History> Hash=new HashMap<Integer,History>();
    float balance;
    int i;

    Transactions(int accNo, User user){
       this.balance= user.getBalance(accNo);
    }

    private void withdraw(Scanner sc){
        System.out.print("Enter the amount to withdraw: ");
        float drawAmt = sc.nextFloat();
        if(drawAmt > balance){
            System.out.println("Your account balance is lesser than withdraw amount.");
        }else{
            balance = balance - drawAmt;
            History his = new History();
            his.setNow();
            his.setBalance(balance);
            his.setWithdraw(drawAmt);
            his.setDeposit(0);
            Hash.put(i,his);
            i+=1;
            System.out.println("Current Balance: "+balance);
        }
        init();
    }

    private void deposit(Scanner sc){
        System.out.print("Enter the amount to deposit: ");
        float amt = sc.nextFloat();
        balance = balance + amt;
        History his = new History();
        his.setNow();
        his.setBalance(balance);
        his.setWithdraw(0);
        his.setDeposit(amt);
        Hash.put(i,his);
        i+=1;
        System.out.println("Current Balance: "+balance);
        init();
    }

    private void viewBalance() {
        System.out.print("Available Balance: ");
        System.out.println(balance);
        init();
    }

    private void viewTransactionHistory(){
        System.out.format("%5s%25s%15s%15s%15s\n", "S. No", "Date","Deposit", "Withdraw", "Balance");
        for (Map.Entry<Integer, History> entry : Hash.entrySet()) {
            History each = entry.getValue();
            System.out.format("%5s",entry.getKey()+1);
            System.out.format("%25s",each.getDate());
            System.out.format("%15s",each.getDeposit());
            System.out.format("%15s",each.getWithdraw());
            System.out.format("%15s\n",each.getBalance());
        }
        init();
    }

    public void init() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose any one operation: ");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. View Balance");
        System.out.println("4. View Transaction History");
        System.out.println("5. Exit");
        int option=sc.nextInt();
        switch(option) {
            case 1:
                deposit(sc);
                break;
            case 2:
                withdraw(sc);
                break;
            case 3:
                viewBalance();
                break;
            case 4:
                viewTransactionHistory();
                break;
            default:
                return;
        }
    }
    private static void authenticate(Scanner sc){
        User users[] = {new User(1001, 1234,4000), new User(1002, 1234,12000), new User(1003, 2345,25000)};
        System.out.print("Enter your account number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter your pin number: ");
        int pin = sc.nextInt();
        User searchUser = new User(accNo, pin,0);
        for(User u: users) {
            if(u.equals(searchUser)) {
                System.out.println("Authentication Successful");
                Transactions trans = new Transactions(accNo,searchUser);
                trans.init();
                break;
            }else{
                System.out.println("Authentication failed. Account Number and pin does not match with our records.");
                System.out.println("Please re-enter Account Number and Pin");
                authenticate(sc);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        authenticate(sc);
    }
}