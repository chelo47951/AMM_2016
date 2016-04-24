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
public class Customer extends User
{
    private Account account;
    private List<ObjectSale> items;
    
    public  Customer()
    {
        items = new ArrayList<>();
    }
    
    public boolean pay(double amount)
    {
        if(account.withdraw(amount))
            return true;
        else
            return false;
    }
    


    private void addToPurchasedItems(ObjectSale objectSale)
    {
       items.add(objectSale);
    }
    
     private void removeFromPurchasedItems(ObjectSale objectSale)
    {
       items.remove(objectSale);
    }
    
    
}
