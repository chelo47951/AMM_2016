/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import java.util.ArrayList;
import java.util.List;
import model.sale.ObjectSale;
import model.sale.ShoppingCart;

/**
 *
 * @author fab
 */
public class Customer extends User
{
   
    private ShoppingCart cart;
    
    public  Customer()
    {
        cart = new ShoppingCart();
    }
    
    public boolean buy(ObjectSale item)
    {
        int num = item.getNumOfItems();
        if(num > 0 &&  pay(item.getPrice()))
        {            
            item.setNumOfItems(--num);
            cart.removeFromCart(item);
            return true;
        }
        else
            return false;
        
    }
    
    
    public boolean pay(double amount)
    {
        if(getAccount().withdraw(amount))
            return true;
        else
            return false;
    }
    


    private void addToCart(ObjectSale objectSale)
    {
       cart.addToCart(objectSale);
    }
    
     private void removeFromPurchasedItems(ObjectSale objectSale)
    {
       cart.removeFromCart(objectSale);
    }
    
    
}
