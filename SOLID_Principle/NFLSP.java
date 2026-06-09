package SOLID_Principle;

import java.nio.channels.AcceptPendingException;
import java.util.ArrayList;
import java.util.List;

abstract class Account {
    abstract void deposite(double amt);

    abstract void withdraw(double amt) throws Exception;

}

class SavingAccount extends Account {
    private double balance;

    SavingAccount() {
        this.balance = 0;
    }

    void deposite(double amt) {
        balance += amt;
        System.out.println("Deposite amount: " + amt + "in saving account. New Balance is: " + balance);
    }

    void withdraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
            System.out.println("Withdraw amount: " + amt + "from saving account. New Balance is: " + balance);
        } else {
            System.out.println("Bank me paisa nahi hai.");
        }
    }

}

class DepositeAccount extends Account {
    private double balance;

    DepositeAccount() {
        this.balance = 0;
    }

    void deposite(double amt) {
        balance += amt;
        System.out.println("Deposite amount: " + amt + "in deposite account. New Balance is: " + balance);
    }

    void withdraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
            System.out.println("Withdraw amount: " + amt + "from deposite account. New Balance is: " + balance);
        } else {
            System.out.println("Bank me paisa nahi hai.");
        }
    }

}

// This is break the Liskov Substitution Principle. This class norrowing the behavior of parent class instead of expend it.

class FixedDepositeAccount extends Account {
    double balance;

    FixedDepositeAccount(double amt) {
        balance = amt;
    }

    void deposite(double amt) {
        balance += amt;
        System.out.println("Deposite amount: " + amt + "in fixeddeposite account. New Balance is: " + balance);
    }

    void withdraw(double amt) throws Exception{
          throw new Exception("Withdraw is not allow in fixed deposite account!");
    }

}

class BankClient{
     private List<Account> accounts = new ArrayList<>();

     BankClient(List<Account> accounts){
       this.accounts = accounts;
     }

     void processTransaction(){
        for(Account acc : accounts){
            acc.deposite(5000);
            try {
                acc.withdraw(3000);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
     }

}

public class NFLSP {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingAccount());
        accounts.add(new DepositeAccount());  
        accounts.add(new FixedDepositeAccount(1000));
        
        BankClient bc = new BankClient(accounts);
        bc.processTransaction();
    }

}
