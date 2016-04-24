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
    public abstract User getUserById(int id);
    public abstract User getUserByUsername(String username);
    public abstract List<User> getUsers();
   
    
}
