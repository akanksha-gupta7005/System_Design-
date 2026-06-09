package SOLID_Principle;

import java.util.ArrayList;
import java.util.List;

// Here We are follow the Liskov Substitution Principle, and no one can break the parent child rule.
abstract class DepositeOnlyAccount {
    abstract void deposite(double amt);
}

abstract class WithdrawAccount extends DepositeOnlyAccount {
    abstract void withdraw(double amt);
}

class SavingAccount extends WithdrawAccount {
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

class DepositeAccount extends WithdrawAccount {
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

class FixedDepositeAccount extends DepositeOnlyAccount {
    double balance;

    FixedDepositeAccount(double amt) {
        balance = amt;
    }

    void deposite(double amt) {
        balance += amt;
        System.out.println("Deposite amount: " + amt + "in fixeddeposite account. New Balance is: " + balance);
    }
}

class BankClient {
    private List<WithdrawAccount> withdrawAccounts = new ArrayList<>();
    private List<DepositeOnlyAccount> depositeOnlyAccounts = new ArrayList<>();

    BankClient(List<WithdrawAccount> withdrawAccounts, List<DepositeOnlyAccount> depositeOnlyAccounts) {
        this.withdrawAccounts = withdrawAccounts;
        this.depositeOnlyAccounts = depositeOnlyAccounts;
    }

    void processTransaction() {
        for (WithdrawAccount acc : withdrawAccounts) {
            acc.deposite(5000);

            acc.withdraw(3000);
        }
        for (DepositeOnlyAccount acc : depositeOnlyAccounts) {
            acc.deposite(600);
        }
    }

}

public class FLSP {

    public static void main(String[] args) {
       List<WithdrawAccount> withdrawAccounts = new ArrayList<>();
       withdrawAccounts.add(new SavingAccount());
       withdrawAccounts.add(new DepositeAccount());

       List<DepositeOnlyAccount> depositeOnlyAccounts = new ArrayList<>();
       depositeOnlyAccounts.add(new FixedDepositeAccount(300));

       BankClient bc = new BankClient(withdrawAccounts, depositeOnlyAccounts);
       bc.processTransaction();
    }

}
