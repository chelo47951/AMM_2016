/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.payment;

import model.factory.user.TestUserFactory;
import model.sale.ObjectSale;
import model.user.Customer;

/**
 *
 * @author fab
 */
public class PaymentSystem 
{
    
    /*
    private static PaymentSystem instance;
    
      public static PaymentSystem getInstance()
    {
       if(instance == null)
       {
           instance = new PaymentSystem();
       }
       
        return instance;
    }
    */
    
    public static Transaction buy(ObjectSale objectSale, Customer customer)
    {
        boolean isSuccess = false;
        String msg;
        
        Transaction t = new Transaction(objectSale, customer);
        isSuccess = t.commit();
    
        
        return t;
    }
}
