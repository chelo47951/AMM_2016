/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.payment;

import model.user.User;

/**
 *
 * @author fab
 */
public class Account
{
    
    
    private User owner;
    
    private double balance;
    private boolean active;
    private boolean overdraft;
    
    public Account(User owner)
    {
        this.owner = owner;
        
        balance = 0.00;
        active = true;
        overdraft = false;
    }
    
    public Account(User owner, double initialAmount)
    {
         this(owner);
         balance+= initialAmount;        
    }
    
    public boolean deposit(double amount)
    {
        // Al momento non sono definite condizioni che consentono il fallimento dell'accredito
        balance+= amount;
        return true;
    }
    
     public boolean withdraw(double amount)
    {
        if(amount <= getBalance())
        {
             balance-= amount;
             return true;
        }
        else
            return false;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }
    
    
}
