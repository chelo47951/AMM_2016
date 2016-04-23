/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author fab
 */
public class Transaction 
{
    private int transactionId; 
    private Vendor vendor;
    private Customer customer;
    private float amount;
    
    public Transaction(ObjectSale objectSale, Customer customer)
    {
        Random rn = new Random();
        transactionId =  rn.nextInt();
        
        this.vendor = objectSale.getVendor();
        this.customer = customer; 
        this.amount = objectSale.getPrice();
    
    }
    
     public boolean purchase()
    {
        if(customer.pay(amount) &&  vendor.creditMoney(amount) )
          return true;
        else
            return false;
    }
    
     private boolean commit()
    { 
        if(purchase())
        {
            persistChanges();
            return true;
        }
        else
        return rollBack();
    }
    
    private boolean rollBack()
    {
        return false;
    }

    private void persistChanges() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 
    
}
