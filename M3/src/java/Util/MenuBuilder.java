/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static Util.Constant.*;

/**
 *
 * @author fab
 */
public class MenuBuilder 
{
    private HashMap<String,List<MenuLi>> pageMenu;
    
    public MenuBuilder()
    {
        pageMenu = new HashMap<>();
        
        
        List<MenuLi> descItems = new ArrayList<MenuLi>();
        
        descItems.add( new MenuLi("login.html","Login") );
        
        pageMenu.put(DESCRIPTION_PAGE,
                        descItems                 
                     );
        
        
        
         List<MenuLi> loginItems = new ArrayList<MenuLi>();
         
         loginItems.add( new MenuLi("descrizione.html","Descrizione") );
         loginItems.add(  new MenuLi("cliente.html","Cliente")  );
         loginItems.add(  new MenuLi("venditore.html","Venditore") );
        
         pageMenu.put(LOGIN_PAGE,
                       loginItems          
                     );
         
         
         
          List<MenuLi> clientItems = new ArrayList<MenuLi>();
   
          clientItems.add(new MenuLi("descrizione.html","Descrizione"));
          clientItems.add(new MenuLi("login.html","Login") );
          
           pageMenu.put(CUSTOMER_PAGE,
                       clientItems          
                     ); 
           
           
           
          List<MenuLi> vendItems = new ArrayList<MenuLi>();
          
          vendItems.add(new MenuLi("descrizione.html","Descrizione"));
          vendItems.add(new MenuLi("login.html","Login") );
          
            pageMenu.put(VENDOR_PAGE,
                      vendItems          
                    ); 
            
            
            
          List<MenuLi> buyItems = new ArrayList<MenuLi>();
   
          buyItems.add(new MenuLi("descrizione.html","Descrizione"));
          buyItems.add(new MenuLi("login.html","Login") );
          
           pageMenu.put(BUY_PAGE,
                       buyItems          
                     ); 
            
          
        
    }
    
    public List<MenuLi> getMenuByPage(String page)
    {
        return pageMenu.get(page);
    }
    
    

    
}
