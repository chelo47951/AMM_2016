/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fab
 */
public class Account
{
    
  
    
    private double balance;
    private boolean active;
    private boolean overdraft;
    
    public Account()
    {
        balance = 0.00;
        active = true;
        overdraft = false;
    }
    
    public Account(float initialAmount)
    {
         this();
         balance+= initialAmount;        
    }
    
    public boolean deposit(double amount)
    {
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
