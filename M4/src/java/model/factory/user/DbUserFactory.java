/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.factory.user.UserFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.user.Customer;
import model.user.User;
import model.user.Vendor;

import static Util.Constant.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.payment.Account;

/**
 *
 * @author fab
 */
public class DbUserFactory extends UserFactory
{
     private static DbUserFactory instance;
     private Connection conn;
     
   
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
    
     public static DbUserFactory getInstance()
    {
       if(instance == null)
       {
           instance = new DbUserFactory();
       }
       
        return instance;
    }

 

    @Override
    public User getUserByUsername(String username) 
    {
        User usr = null;
        
         connect();
         try 
         {
             String sql = "select * from USERS "
                     + "where USERNAME = ?";
             
             PreparedStatement stmt = conn.prepareStatement(sql);
             
             stmt.setString(1, username);
             
             ResultSet set = stmt.executeQuery();
             
             while (set.next()) 
             {
                 String userType = set.getString("USER_TYPE");
                 if(userType.equals(IS_CUSTOMER))
                 {
                     Customer c = new Customer();
                     
                     c.setUserId(set.getInt("USER_ID"));
                     c.setFname(set.getString("FNAME"));
                     c.setLname(set.getString("LNAME"));
                     c.setUsername(username);
                     c.setPassword(set.getString("PASSWORD"));
                     c.setAddress(set.getString("ADDRESS"));
                     
                     //Occorre l'account 
                     Account a = getAccountByUserId(c);
                     
                     c.setAccount(a);
                     
                     usr = c;                     
                 }
                 else if(userType.equals(IS_VENDOR))
                 {
                     
                     Vendor v = new Vendor();
                     
                     v.setUserId(set.getInt("USER_ID"));
                     v.setFname(set.getString("FNAME"));
                     v.setLname(set.getString("LNAME"));
                     v.setUsername(username);
                     v.setPassword(set.getString("PASSWORD"));
                     v.setAddress(set.getString("ADDRESS"));
                     
                     //Occorre l'account 
                     Account a = getAccountByUserId(v);
                     
                     v.setAccount(a);
                     
                     usr = v;        
                     
                 }
                 
                 
                
             }
             
              stmt.close();
              disconnect();
              return usr;
             
         }
         catch (SQLException ex)
         {
             Logger.getLogger(DbUserFactory.class.getName()).log(Level.SEVERE, null, ex);
            
             disconnect();
             return null;
            
         }
         
        
    }
            

    @Override
    public List<User> getUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> getCustomers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vendor> getVendors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verifyPassword(String username,  String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vendor getVendorByUsername(String username) 
    {
        Vendor v = null;
        
         connect();
         try 
         {
             String sql = "select * from USERS "
                     + "where USERNAME = ?";
             
             PreparedStatement stmt = conn.prepareStatement(sql);
             
             stmt.setString(1, username);
             
             ResultSet set = stmt.executeQuery();
             
             while (set.next()) 
             {
                 String userType = set.getString("USER_TYPE");
 
                 if(userType.equals(IS_VENDOR))
                 {
                     
                     v = new Vendor();
                     
                     v.setUserId(set.getInt("USER_ID"));
                     v.setFname(set.getString("FNAME"));
                     v.setLname(set.getString("LNAME"));
                     v.setUsername(username);
                     v.setPassword(set.getString("PASSWORD"));
                     v.setAddress(set.getString("ADDRESS"));
                     
                     //Occorre l'account 
                     Account a = getAccountByUserId(v);
                     
                     v.setAccount(a);
                     
                     
                 }
                 
                 
                
             }
             
              stmt.close();
              disconnect();
              return v;
             
         }
         catch (SQLException ex)
         {
             Logger.getLogger(DbUserFactory.class.getName()).log(Level.SEVERE, null, ex);
            
             disconnect();
             return null;
            
         }
    }

    @Override
    public Customer getCustomerById(int id)
    {
         Customer c = null;
        
         connect();
         try 
         {
             String sql = "select * from USERS "
                     + "where USER_ID = ?";
             
             PreparedStatement stmt = conn.prepareStatement(sql);
             
             stmt.setInt(1, id);
             
             ResultSet set = stmt.executeQuery();
             
             while (set.next()) 
             {
                 String userType = set.getString("USER_TYPE");
 
                 if(userType.equals(IS_CUSTOMER))
                 {
                     
                     c = new Customer();
                     
                     c.setUserId(set.getInt("USER_ID"));
                     c.setFname(set.getString("FNAME"));
                     c.setLname(set.getString("LNAME"));
                     c.setPassword(set.getString("PASSWORD"));
                     c.setAddress(set.getString("ADDRESS"));
                     
                     //Occorre l'account 
                     Account a = getAccountByUserId(c);
                     
                     c.setAccount(a);
                     
                     
                 }
                 
                 
                
             }
             
              stmt.close();
              disconnect();
              return c;
             
         }
         catch (SQLException ex)
         {
             Logger.getLogger(DbUserFactory.class.getName()).log(Level.SEVERE, null, ex);
            
             disconnect();
             return null;
            
         }
    }

    @Override
    public Vendor getVendorById(int id) 
    {
         Vendor v = null;
        
         connect();
         try 
         {
             String sql = "select * from USERS "
                     + "where USER_ID = ?";
             
             PreparedStatement stmt = conn.prepareStatement(sql);
             
             stmt.setInt(1, id);
             
             ResultSet set = stmt.executeQuery();
             
             while (set.next()) 
             {
                 String userType = set.getString("USER_TYPE");
 
                 if(userType.equals(IS_VENDOR))
                 {
                     
                     v = new Vendor();
                     
                     v.setUserId(set.getInt("USER_ID"));
                     v.setFname(set.getString("FNAME"));
                     v.setLname(set.getString("LNAME"));
                     v.setPassword(set.getString("PASSWORD"));
                     v.setAddress(set.getString("ADDRESS"));
                     
                     //Occorre l'account 
                     Account a = getAccountByUserId(v);
                     
                     v.setAccount(a);
                     
                     
                 }
                 
                 
                
             }
             
              stmt.close();
              disconnect();
              return v;
             
         }
         catch (SQLException ex)
         {
             Logger.getLogger(DbUserFactory.class.getName()).log(Level.SEVERE, null, ex);
            
             disconnect();
             return null;
            
         }
       
    }

    private Account getAccountByUserId(User usr)
    {
        Account a = null;
        connect();
        
         try 
         {
             String sql = "select * from ACCOUNTS "
                     + "where USER_ID = ?";
             
             PreparedStatement stmt = conn.prepareStatement(sql);
             
             stmt.setInt(1, usr.getUserId());
             
             ResultSet set = stmt.executeQuery();
             
             while (set.next()) 
             {
                 
                     double initialAmount = set.getDouble("BALANCE");
                     a = new Account(usr,initialAmount);
                     
              }
                
             }
             
         
            catch (SQLException ex)
            {
                Logger.getLogger(DbUserFactory.class.getName()).log(Level.SEVERE, null, ex);
                disconnect();
                return a;

            }
        
        
        
        disconnect();
        return a;
    }

 
}
