package ufps.poo2.ejercicio.banco.modelo;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void openAccount(char type, int accnum) {
        if (type == 'A') {
            accounts.add(new SavingsAccount(accnum)); 
            System.out.println("SavingsAccount " + accnum + " opened.");
        }
        if (type == 'C') {
            accounts.add(new CurrentAccount(accnum)); 
            System.out.println("CurrentAccount " + accnum + " opened.");
        
    }
    }
    
   public void payDividend(int accnum, double amount) {
    Account account = findAccount(accnum);
    if (account != null) {
        account.deposit(amount); 
        System.out.println("Dividend of " + amount + " paid to account " + accnum);
        System.out.println(account.toString());
    } else {
        System.out.println("Account not found");
    }
}



    
public void withdrawAccount(int accnum, double amount){
      Account account = findAccount(accnum);
    if (account != null) {
        account.withdraw(amount);
        System.out.println("Dividend of " + amount + " paid to account " + accnum);
        System.out.println(account.toString());
    } else {
        System.out.println("Account not found");
    }
    
    }



    
    //exception para cuando no se encontró la cuenta
    public double getBalance(int accnum) {
        Account account = findAccount(accnum);
        if (account != null) {
            return account.getBalance();
        } else {
            System.out.println("Account not found.");
        }
        return -1;
    }
    
    
    
//Mandar las cartas, creo que tocará es un toString como hicimos con el otro no me acuerdo el nombre
//creo que hay que corregir, sobregiro no cuenta cuando el limite es en -5 y está en -2?
    public ArrayList sendLetterToOverdraftAccounts() {
        ArrayList <Integer> ac = new ArrayList<>();
        for (Account acc : accounts) {
            if (acc.getBalance() < 0) {
                ac.add(acc.getAccountNumber());
            }
        }
        return ac;
    }
    
    public Account findAccount(int accnum) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accnum) {
                return acc;
            }
        }
        return null;
    }
}
