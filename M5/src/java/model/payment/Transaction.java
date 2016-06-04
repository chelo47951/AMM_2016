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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import model.factory.sale.ObjectSaleFactory;
import model.factory.sale.ObjectSaleFactoryBuilder;
import model.factory.user.DbUserFactory;
import model.factory.user.UserFactory;
import model.factory.user.UserFactoryBuilder;

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
    private  String appMode;
    private Connection conn;
    private String connectionString;
   
     
   
     public void connect() 
     {
         try 
         {
             conn = DriverManager.getConnection(connectionString, DB_USERNAME, DB_PASSWORD);
         } 
         catch (SQLException ex)
         {
             Logger.getLogger(DbUserFactory.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
     
      public void disconnect()
     {
         try 
         {
             conn.close();
         } 
         catch (SQLException ex) 
         {
             Logger.getLogger(DbUserFactory.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    
    
    public Transaction(ObjectSale objectSale, Customer customer, String appMode)
    {
        Random rn = new Random();
        transactionId =  Math.abs( rn.nextInt() % Constant.MAX_ID  );
        
        this.vendor = objectSale.getVendor();
        this.customer = customer; 
        this.amount = objectSale.getPrice();
        this.objectSale = objectSale;
        this.isSuccess = false;
        this.appMode = appMode;
     
    }
    
     private boolean buy()
    {
        boolean isCustomerSuccess = false, isVendorSuccess = false;
        if( (isCustomerSuccess = customer.pay(amount)) && (isVendorSuccess = vendor.creditMoney(amount)) )
        {
          int num = objectSale.getNumOfItems();
          objectSale.setNumOfItems(--num);
          

         
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
           if(appMode.equals(DB_FACTORY_MODE))  // La transazione sul db viene persistita solo in DB_FACTORY_MODE   
              persistChanges();
           
            message = TRANSACTION_COMMITED_MESSAGE_TEXT;
       
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
        try {
            //Salva su db
            
            UserFactory usrFactory = UserFactoryBuilder.getFactory(DB_FACTORY_MODE);
            ObjectSaleFactory objFactory = ObjectSaleFactoryBuilder.getFactory(DB_FACTORY_MODE);
            
            connectionString = usrFactory.getConnectionString();
            
            connect();
            conn.setAutoCommit(false);
            
            // Inizia transazione su db
           boolean oFlag = objFactory.updateSellingObjectList(objectSale);      // Aggiorna la lista oggetti
           boolean cFlag = usrFactory.updateAccount(customer.getAccount(), amount, true);  // Addebita al cliente
           boolean vFlag = usrFactory.updateAccount(vendor.getAccount(), amount, false);   // Accredita al venditore
           
           if(!oFlag || !cFlag || !vFlag)
               conn.rollback();
            
            //fine transazione
            
              //La transazione è andata a buon fine: registriamola sul db come storico
            recordTransactionDataOnDb();
            

           
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
            try 
            {
                conn.rollback();
            }
            catch (SQLException ex1)
            {
                Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        finally
        {
            try 
            {
                conn.setAutoCommit(true);
              
            }
            catch (SQLException ex)
            {
                Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
            }
          disconnect();   
        }
         
         
         
        
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

    private boolean recordTransactionDataOnDb()
    {
        
            
        try
        {
          connect();
            
           String sql = "INSERT INTO TRANSACTIONS (TRANSACTION_ID ,CUSTOMER_ID ,VENDOR_ID ,OBJECT_NAME,AMOUNT,COMMIT_DATE ) " +
            " VALUES (default,?,?,?,?,default)";
             
             PreparedStatement stmt = conn.prepareStatement(sql);
             
             stmt.setInt(1,customer.getUserId());
             stmt.setInt(2,vendor.getUserId());
             stmt.setString(3, objectSale.getName());            
             stmt.setDouble(4,amount );
            
             
             
             int numOrRows = stmt.executeUpdate();
            
         // disconnect(); 
          
          if(numOrRows != 1)
              return false;
          else
              return true;
         
        }
        catch(SQLException ex)
        {
             Logger.getLogger(DbUserFactory.class.getName()).log(Level.SEVERE, null, ex);
             disconnect();
             return false;
        }     
        
    }
    
 
    
}
