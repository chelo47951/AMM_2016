/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory.user;

import java.util.List;
import model.user.Customer;
import model.user.User;
import model.user.Vendor;

/**
 *
 * @author fab
 */
public abstract class UserFactory 
{
        
   protected String connectionString;
   
   public void setConnectionString(String s)
   {
	this.connectionString = s;
   }
    public String getConnectionString()
    {
            return this.connectionString;
    } 
    
    
    protected  List<User> users;
    protected  List<Customer> customers;
    protected  List<Vendor> vendors;

   
    public abstract List<User> getUsers();
    public abstract List<Customer> getCustomers();
    public abstract List<Vendor> getVendors();
    
    // Ricerca un utente per username
    public abstract User getUserByUsername(String username); 
    
    // Ricerca un cliente per username
    public abstract Customer getCustomerByUsername(String username); 
    
   // Ricerca un venditore per username
    public abstract Vendor getVendorByUsername(String username); 
    
    
        // Ricerca un cliente per username
    public abstract Customer getCustomerById(int id); 
    
   // Ricerca un venditore per username
    public abstract Vendor getVendorById(int id); 
    
    
    
    public abstract boolean verifyPassword(String username,  String password);
    
    public boolean verifyPassword(User usr,  String password) 
    {
        if(usr.getPassword().equals(password))
            return true;
        else
            return false;
    }
    
   
    
}
