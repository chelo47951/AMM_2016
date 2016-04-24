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
         
         Customer c1 = new Customer();
         c1.setUserId(1);
         
         c1.setFname("Mario");
         c1.setLname("Rossi");
         
         c1.setUsername("rossim60");
         c1.setPassword("roma1960");
         
         Account a1 = new Account(c1);
         a1.deposit(500.00);
         c1.setAccount(a1);
         
         Vendor v1 = new Vendor();
         v1.setUserId(5);
         
         v1.setFname("Giuseppe");
         v1.setLname("Verdi");
         
         v1.setUsername("verdig55");
         v1.setPassword("milano1955");
         
         Account a2 = new Account(v1, 100.00);        
         v1.setAccount(a2);
                
         
        
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
    public User getUserById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getUsers() 
    {
        return users;
    }
    
}
