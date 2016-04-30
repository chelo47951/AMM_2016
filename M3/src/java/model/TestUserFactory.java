/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fab
 */
public class TestUserFactory extends UserFactory 
{
    private static TestUserFactory instance;
    
    private  TestUserFactory()
    {
         users = new ArrayList<>();
         customers = new ArrayList<>();
         vendors = new ArrayList<>();
         
         Customer c1 = new Customer();
         c1.setUserId(1);
         
         c1.setFname("Mario");
         c1.setLname("Rossi");
         
         c1.setUsername("rossim60");
         c1.setPassword("1960");
         
         Account a1 = new Account(c1);
         a1.deposit(500.00);
         c1.setAccount(a1);
         
         users.add(c1);
         customers.add(c1);
         
         
         Vendor v1 = new Vendor();
         v1.setUserId(1);
         
         v1.setFname("Giuseppe");
         v1.setLname("Verdi");
         
         v1.setUsername("verdig55");
         v1.setPassword("1955");
         
         Account a2 = new Account(v1, 100.00);        
         v1.setAccount(a2);
         
         users.add(v1);
         vendors.add(v1);
                
         
        
    }
    
    public static TestUserFactory getInstance()
    {
       if(instance == null)
       {
           instance = new TestUserFactory();
       }
       
        return instance;
    }
    

    @Override
    public List<User> getUsers() 
    {
        return users;
    }

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public List<Vendor> getVendors() {
        return vendors;
    }


    @Override
    public User getUserByUsername(String username) 
    {
        if(username == null || username.equals(""))
            return null;
               
        for(User u: users)
        {
            if(u.getUsername().equals(username))
            {
                //trovato
                return u;
            }
        }
        
        return null;
        
    }

    @Override
    public  boolean verifyPassword(String username, String password) 
    {
        
        if(username == null || password == null || password.equals(""))
            return false;
        
        User user = getUserByUsername(username);
        
        if(user == null)
            return false;
        
        if( user.getPassword().equals(password))
            return true;
        else
            return false;
        
    }

    @Override
    public Customer getCustomerByUsername(String username) 
    {
        if(username == null || username.equals(""))
            return null;
               
        for(Customer c: customers)
        {
            if(c.getUsername().equals(username))
            {
                //trovato
                return c;
            }
        }
        
        return null;
    }

    @Override
    public Vendor getVendorByUsername(String username)
    {
      
         if(username == null || username.equals(""))
            return null;
               
        for(Vendor v: vendors)
        {
            if(v.getUsername().equals(username))
            {
                //trovato
                return v;
            }
        }
        
        return null;
    }
    
    
    
}
