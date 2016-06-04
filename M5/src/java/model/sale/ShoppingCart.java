/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.sale;

import Util.Constant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author fab
 */
public class ShoppingCart
{
      //Icona
     public final static String SHOP_CART_ICON = "img/icona-carrello.png";
    
     private int ShoppingCartId;
     
     private List<ObjectSale> items;    
     private int numOfItems;
     
     
     public ShoppingCart()
     {
          Random rn = new Random();                       
          this.ShoppingCartId = Math.abs(  rn.nextInt() % Constant.MAX_ID  ); 
         
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
         getItems().clear();
         numOfItems = 0;
     }

    /**
     * @return the numOfItems
     */
    public int getNumOfItems() {
        return getItems().size();
    }

    /**
     * @return the items
     */
    public List<ObjectSale> getItems() {
        return items;
    }

   
     
     
   
     
    
}
