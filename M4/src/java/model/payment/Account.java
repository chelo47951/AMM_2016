/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.payment;

import Util.Constant;
import java.util.Random;
import model.user.User;

/**
 *
 * @author fab
 */
public class Account
{
    
    private int accountId;
    private User owner;    
    private double balance;
    private boolean active;
    private boolean overdraft;
    
    public Account(User owner)
    {
        this.owner = owner;
        
        Random rn = new Random(); 
        
        accountId =   Math.abs( rn.nextInt() % Constant.MAX_ID  );
        balance = 0.00;
        active = true;
        overdraft = false;
    }
    
    public Account(User owner, double initialAmount)
    {
         this(owner);
         balance+= initialAmount;        
    }
    
    public Account(int accountId, User owner, double initialAmount)
    {
        this.owner = owner;
        this.accountId = accountId;
        
        this.balance = 0.00;
        
        active = true;
        overdraft = false;
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

    /**
     * @return the accountId
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    
    
}
