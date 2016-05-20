/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import model.sale.ObjectSale;
import model.user.User;

/**
 *
 * @author fab
 */
public class Vendor extends User
{
  
    
    public void sellObject(ObjectSale objectSale)
    {
        objectSale.setVendor(this);
    }

    public boolean creditMoney(double amount)
    {
        if(getAccount().deposit(amount))
            return true;
        else
            return false;
    }
    
}
