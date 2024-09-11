/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.controlador;

import java.util.ArrayList;
import ufps.poo2.ejercicio.banco.modelo.Account;
import ufps.poo2.ejercicio.banco.modelo.Bank;
import ufps.poo2.ejercicio.banco.vista.BancoVista;

/**
 *
 * @author Boris Perez
 */
public class BancoControlador {
    private Bank banco;
    private BancoVista frame;
    
    public BancoControlador(BancoVista frame){
        banco = new Bank();
        this.frame = frame;
    }
    
    
   public void abrirCuenta(){
        int numeroCuenta = Integer.parseInt(frame.getTxtNumeroCuenta().getText());
        double saldo = Double.parseDouble(frame.getTxtSaldoCuenta().getText());
        String a = frame.getButtonGroup1().getSelection().getActionCommand();
        System.out.println(a);
        char tipoCuenta; 
        if(a.equals("Cta. Ahorros")){
            tipoCuenta = 'A'; 
         } else {
            tipoCuenta = 'C'; 
    }
         
        banco.openAccount(tipoCuenta, numeroCuenta);
        banco.payDividend(numeroCuenta, saldo);
        
         Account cuenta = banco.findAccount(numeroCuenta);
        mostrarMensaje(cuenta.toString());
        
        
        cancelar();
        
}

    public void cancelar(){
        frame.getTxtNumeroCuenta().setText("");
        frame.getTxtSaldoCuenta().setText("");
    }
    
    public void aplicar(){
        String accion = frame.getButtonGroupAcciones().getSelection().getActionCommand();
        int numeroCuenta = Integer.parseInt(frame.getTxtNumeroCuentaAcciones().getText());
        
        double amount = Double.parseDouble(frame.getTxtValor().getText());
        
        if(accion == "Retirar"){
            banco.withdrawAccount(numeroCuenta, amount);
            
        }else{
             banco.payDividend(numeroCuenta, amount);
        }
        Account cuenta = banco.findAccount(numeroCuenta);
        mostrarMensaje(cuenta.toString());
        
        
        cancelar2(); 
        
    }
    
   public void cancelar2(){
       frame.getTxtNumeroCuentaAcciones().setText("");
       frame.getTxtValor().setText("");
       
   }
    public void mostrarMensaje(String mensaje){
        frame.getTaMensajes().append(mensaje + "\n");
    }
    
    
    public void mandarCorreos(){
        ArrayList <Integer> ac =  banco.sendLetterToOverdraftAccounts();
        frame.getTaMensajes().append("Overdraft accounts " + "\n");
        for (int acc : ac) {
            frame.getTaMensajes().append("Account: " + acc + "\n");
        }
    }
    
    
}
