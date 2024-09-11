/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

/**
 *
 * @author Michell
 */
public class SavingsAccount extends Account {

    private double interest = 0.03;

    public SavingsAccount(int accnum) {
        super(accnum);
        
    }

    @Override
    public void deposit(double sum) {
        if (sum > 0) {
            double interestAmount = getBalance() * interest;
            super.deposit(sum + interestAmount);
        } else {
            System.err.println("SavingsAccount.deposit(...): cannot deposit negative amount.");
        }
    }

     @Override
   public void withdraw(double sum) {
	if (super.getBalance() >= sum){
            super.withdraw(sum);
        }
    }
  
    @Override
    public String toString() {
        return "SavingsAccount " + getAccountNumber() + ": balance = " + getBalance();
    }
}

