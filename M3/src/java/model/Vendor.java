/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fab
 */
public class Vendor extends User
{
    private Account account;
    
    public void sellObject(ObjectSale objectSale)
    {
        objectSale.setVendor(this);
    }

    public boolean creditMoney(double amount)
    {
        if(account.deposit(amount))
            return true;
        else
            return false;
    }
    
}
