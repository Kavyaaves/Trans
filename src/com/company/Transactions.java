package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Transactions {
    HashMap<Integer, History> Hash=new HashMap<Integer,History>();
    float balance;
    int i;

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
        System.out.println("Select one: ");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. View Balance");
        System.out.println("4. Transaction History");
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

    public static void main(String[] args) {
        Transactions trans=new Transactions();
        trans.init();
    }
}