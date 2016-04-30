/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.payment;

import model.user.Vendor;
import model.user.Customer;
import Util.Constant;
import java.util.Random;
import model.sale.ObjectSale;

/**
 *
 * @author fab
 */
public class Transaction 
{
    private int transactionId; 
    private Vendor vendor;
    private Customer customer;
    private double amount;
    
    public Transaction(ObjectSale objectSale, Customer customer)
    {
        Random rn = new Random();
        transactionId =  Math.abs( rn.nextInt() % Constant.MAX_ID  );
        
        this.vendor = objectSale.getVendor();
        this.customer = customer; 
        this.amount = objectSale.getPrice();
    
    }
    
     private boolean buy()
    {
        if(customer.pay(amount) &&  vendor.creditMoney(amount) )
          return true;
        else
            return false;
    }
    
     private boolean commit()
    { 
        if(buy())
        {
            persistChanges();
            return true;
        }
        else
        return rollBack();
    }
    
    private boolean rollBack()
    {
        // TODO:  Ripristina lo stato prima dell'acquisto
        return false;
    }

    private void persistChanges() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 
    
}
