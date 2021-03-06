/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import static Util.Constant.SHOPPER;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
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
            //todo: update db item
            getCart().removeFromCart(item);
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
    
    public boolean refund(double amount)
    {
        if(getAccount().deposit(amount))
            return true;
        else
            return false;
    }
    


    public void addToCart(ObjectSale objectSale)
    {
        getCart().addToCart(objectSale);
    }
    
     public void removeFromPurchasingItems(ObjectSale objectSale)
    {
          
        
    }
     
     public void checkoutItem(ObjectSale objectSale)
     {
          removeFromPurchasingItems(objectSale);
     }

    /**
     * @return the cart
     */
    public ShoppingCart getCart() {
        return cart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }
    
    
}
