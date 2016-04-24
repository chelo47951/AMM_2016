/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Util.Constant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author fab
 */
public class ShoppingCart
{
      //Icona
     public final static String SHOP_CART_ICON = "img/icona-carrello.png";
    
     private int ShoppingCartId;
     
     protected List<ObjectSale> items;    
     protected int numOfItems;
     
     
     public ShoppingCart()
     {
          Random rn = new Random();                       
          this.ShoppingCartId =  rn.nextInt() % Constant.MAX_ID; 
         
         numOfItems = 0;
         items =  new ArrayList<>();
     }
     
     public void addToCart(ObjectSale item)
     {
         items.add(item);
         numOfItems++;
     }
     
      public void removeFromCart(ObjectSale item)
     {
         items.remove(item);
         numOfItems--;
     }
      
       public void clearCart()
     {
         items.clear();
         numOfItems = 0;
     }
     
     
   
     
    
}
