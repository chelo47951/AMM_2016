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

// Le costanti utilizzate nel codice
import static Util.Constant.*;

/**
 *
 * @author fab
 */
public class Transaction 
{
    private int transactionId; 
    private Vendor vendor;
    private Customer customer;
    private ObjectSale objectSale;
    private double amount;
    private boolean isSuccess;
    private String message;
    private String rollbackReasonMessage;
    
    
    public Transaction(ObjectSale objectSale, Customer customer)
    {
        Random rn = new Random();
        transactionId =  Math.abs( rn.nextInt() % Constant.MAX_ID  );
        
        this.vendor = objectSale.getVendor();
        this.customer = customer; 
        this.amount = objectSale.getPrice();
        this.objectSale = objectSale;
        this.isSuccess = false;
    }
    
     private boolean buy()
    {
        boolean isCustomerSuccess = false, isVendorSuccess = false;
        if( (isCustomerSuccess = customer.pay(amount)) && (isVendorSuccess = vendor.creditMoney(amount)) )
        {
          int num = objectSale.getNumOfItems();
          objectSale.setNumOfItems(--num);
          
          customer.checkoutItem(objectSale);
         
          return true;
        }
        else
        {
            if(!isCustomerSuccess)
            { 
                rollbackReasonMessage = TRANSACTION_ROLLEDBACK_REASON_CUSTOMER_TEXT;
                
                
            }
            else if(!isVendorSuccess)
            {
                rollbackReasonMessage = TRANSACTION_ROLLEDBACK_REASON_VENDOR_TEXT;
            }
        }
            return false;
    }
    
     public boolean commit()
    { 
        if(buy())
        {
            message = TRANSACTION_COMMITED_MESSAGE_TEXT;
            persistChanges();
            isSuccess = true;
            return true;
        }
        else
        {
           message = TRANSACTION_ROLLEDBACK_MESSAGE_TEXT + rollbackReasonMessage;           
           return rollBack();
        }
    }
    
    private boolean rollBack()
    {
         isSuccess = false;
        // TODO:  Ripristina lo stato prima dell'acquisto
        return false;
    }

    private void persistChanges() 
    {
       //Salva su db
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the isSuccess
     */
    public boolean isIsSuccess() {
        return isSuccess;
    }
    
 
    
}
