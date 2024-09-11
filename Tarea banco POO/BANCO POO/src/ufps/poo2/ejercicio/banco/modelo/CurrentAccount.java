/*|||||||||||||||||||||||||||||||||
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

/**
 *
 * @author Michell
 */

public class CurrentAccount extends Account {

    private double overdraftLimit = 5;

    public CurrentAccount(int accnum) {
        super(accnum);
        
    }

//exception para cuando es negativo, una para cuando alcanzó el límite?
    @Override
    public void withdraw(double sum) {
        if (sum < 0) {
            if (getBalance() + overdraftLimit >= sum) {
                super.withdraw(sum);
            } else {
                System.err.println("CurrentAccount.withdraw(...): Insufficient funds, overdraft limit exceeded.");
            }
        } else {
            System.err.println("CurrentAccount.withdraw(...): cannot withdraw negative amount.");
        }
    }

    @Override
    public String toString() {
        return "CurrentAccount " + getAccountNumber() + ": balance = " + getBalance();
    }
}

