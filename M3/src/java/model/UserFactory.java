/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author fab
 */
public abstract class UserFactory 
{
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
    
    public abstract boolean verifyPassword(String username,  String password);
    
   
    
}
