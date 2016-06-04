/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.sale.ObjectSale;
import model.factory.sale.ObjectSaleFactory;
import model.factory.sale.TestObjectSaleFactory;


// Le costanti utilizzate nel codice

import model.factory.sale.ObjectSaleFactoryBuilder;
import model.user.Customer;
import model.factory.user.TestUserFactory;
import model.factory.user.UserFactory;
import model.factory.user.UserFactoryBuilder;
import model.user.Vendor;

import static Util.Constant.*;
import Util.MenuBuilder;
import Util.MenuLi;
import Util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import model.payment.Account;
import model.payment.PaymentSystem;
import model.payment.Transaction;
import model.sale.ShoppingCart;


/**
 *
 * @author fab
 */
@WebServlet(name = "Acquista", urlPatterns = {"/acquista.html"})
public class Acquista extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        
        MenuBuilder mb = new MenuBuilder();        
       
        
        HttpSession session = request.getSession(false);        
       
         if(session != null)
        {
            String appMode = session.getServletContext().getInitParameter(APP_MODE);
            
            UserFactory usrFactory = UserFactoryBuilder.getFactory(appMode);
            ObjectSaleFactory objFactory = ObjectSaleFactoryBuilder.getFactory(appMode);

            Enumeration<String> attributes = session.getAttributeNames();
            boolean isCustomerPresent = false;
        
            while (attributes.hasMoreElements())
            {
              String name = (String) attributes.nextElement();
              
              if(name.equals(IS_CUSTOMER))
              {
                  isCustomerPresent = true;
                  break;
              }
            }

            if(isCustomerPresent)
            {
                Boolean isCustomer = (Boolean)session.getAttribute(IS_CUSTOMER);
                if(isCustomer != null && isCustomer == true)
               { 
                   
                   //La servlet gestisce sia il riepilogo che la conferma dell'acquisto
                   if( request.getParameter("Submit") != null )
                   {
                       //Conferma acquisto
                       Integer CustomerId =  Util.tryParseInt(request.getParameter(CUSTOMER_ID));
                       Integer VendorId =    Util.tryParseInt(request.getParameter(VENDOR_ID));
                       Integer ObjectId =   Util.tryParseInt(request.getParameter(OBJECT_ID));
                       
                       if( CustomerId!= null && CustomerId > 0 &&
                           VendorId!= null && VendorId > 0 &&  
                           ObjectId!= null && ObjectId > 0 )
                       {
                           
                           Customer c = usrFactory.getCustomerById(CustomerId);
                           Vendor v = usrFactory.getVendorById(VendorId);
                           ObjectSale obj = objFactory.getObjectSaleById(ObjectId);
                           
                           if(c != null && v != null && obj != null)
                           {
                               double previousBalance =  c.getAccount().getBalance();
                               Transaction t = PaymentSystem.buy(obj, c,appMode);
                               if(t.isIsSuccess())
                               {
                                   request.setAttribute(TRANSACTION_COMMITED_MESSAGE, t.getMessage());
                                   request.setAttribute(OBJECT_ID,ObjectId);
                                   request.setAttribute(PREVIOUS_BALANCE,previousBalance);
                                   request.setAttribute(CURRENT_PURCHASE,obj.getPrice());
                                   request.setAttribute(CURRENT_BALANCE ,c.getAccount().getBalance() );
                                   ShoppingCart shopper = (ShoppingCart)session.getAttribute(SHOPPER);
                                   shopper.removeFromCart(obj);
                                   
                                   
                               }
                               else
                               {
                                   request.setAttribute(TRANSACTION_ROLLEDBACK_MESSAGE, t.getMessage());
                                 
                               }
                               
                                List<MenuLi> menuItems = mb.getMenuByPage(BUY_PAGE);        
                                request.setAttribute(MENU_ITEMS, menuItems);
                               
                                request.getRequestDispatcher(BUY_PAGE).forward(request, response); 
                               
                           }
                           
                             
                            List<MenuLi> menuItems = mb.getMenuByPage(CUSTOMER_PAGE);        
                            request.setAttribute(MENU_ITEMS, menuItems);
                           
                            request.getRequestDispatcher(CUSTOMER_PAGE).forward(request, response);
                           
                       
                       }
                   
                   }
                   else if( request.getParameter("Checkout") != null)
                   {
                        //Conferma acquisto da Checkout del carrello
                       String username = request.getParameter(USERNAME);
                       Customer c = usrFactory.getCustomerByUsername(username);
                       
                       Integer CustomerId =  c.getUserId();
                     
                       Integer ObjectId =   Util.tryParseInt(request.getParameter(OBJECT_ID));
                       ObjectSale obj = objFactory.getObjectSaleById(ObjectId);
                       Integer VendorId =   obj.getVendor().getUserId();
                       
                       
                       if( CustomerId!= null && CustomerId > 0 &&
                           VendorId!= null && VendorId > 0 &&  
                           ObjectId!= null && ObjectId > 0 )
                       {
                           
                          
                           Vendor v = usrFactory.getVendorById(VendorId);
                          
                           
                           if(c != null && v != null && obj != null)
                           {
                               double previousBalance =  c.getAccount().getBalance();
                               Transaction t = PaymentSystem.buy(obj, c,appMode);
                               if(t.isIsSuccess())
                               {
                                   request.setAttribute(TRANSACTION_COMMITED_MESSAGE, t.getMessage());
                                   request.setAttribute(OBJECT_ID,ObjectId);
                                   request.setAttribute(PREVIOUS_BALANCE,previousBalance);
                                   request.setAttribute(CURRENT_PURCHASE,obj.getPrice());
                                   request.setAttribute(CURRENT_BALANCE ,c.getAccount().getBalance() );
                                   ShoppingCart shopper = (ShoppingCart)session.getAttribute(SHOPPER);
                                   shopper.removeFromCart(obj);
                                   
                                   
                               }
                               else
                               {
                                   request.setAttribute(TRANSACTION_ROLLEDBACK_MESSAGE, t.getMessage());
                                 
                               }
                               
                                List<MenuLi> menuItems = mb.getMenuByPage(BUY_PAGE);        
                                request.setAttribute(MENU_ITEMS, menuItems);
                               
                                request.getRequestDispatcher(BUY_PAGE).forward(request, response); 
                               
                           }
                           
                             
                            List<MenuLi> menuItems = mb.getMenuByPage(CUSTOMER_PAGE);        
                            request.setAttribute(MENU_ITEMS, menuItems);
                           
                            request.getRequestDispatcher(CUSTOMER_PAGE).forward(request, response);
                           
                       
                       }
                       
                   }
                    else if( request.getParameter("TotCheckout") != null)
                   {
                        ShoppingCart shopper = (ShoppingCart) session.getAttribute(SHOPPER);
                   
                        ArrayList<ObjectSale> cartItems = new ArrayList<ObjectSale>(shopper.getItems());
                        Collections.copy(cartItems,shopper.getItems());
                        
                        if(cartItems != null && cartItems.size() > 0)
                        {
                            double totalAmount = 0;
                            for(ObjectSale o: cartItems )
                            {
                               totalAmount += o.getPrice();
                            }
                            
                           
                             String username = (String)session.getAttribute(USERNAME);
                             Customer c = usrFactory.getCustomerByUsername(username);
                       
                             Integer CustomerId =  c.getUserId();
                             
                                                      
                             if( c.getAccount().getBalance() < totalAmount)
                             {
                                 //Non si può effettuare il checkout totale
                                 request.setAttribute(TRANSACTION_ROLLEDBACK_MESSAGE, TOTAL_CHECKOUT_ROLLEDBACK_REASON_CUSTOMER_TEXT);
                                 
                                 request.setAttribute("cartItems", shopper.getItems());
                                 request.setAttribute("totalAmount", totalAmount);
                      
                                 List<MenuLi> menuItems = mb.getMenuByPage(CART_PAGE);        
                                 request.setAttribute(MENU_ITEMS, menuItems);

                                 request.getRequestDispatcher(CART_PAGE).forward(request, response);
                                 
                             }
                             else
                             {
                                 
                                 // Procediamo all'acquisto di tutti i pezzi
                                 // Ogni pezzo una transazione
                                 totalAmount = 0;
                                 int numBought = 0;
                                 double previousBalance =  c.getAccount().getBalance();
                                 
                               for(ObjectSale obj: cartItems )
                               {
                                    //-----------------------------------------------------------------------
                       
                                    Integer VendorId =   obj.getVendor().getUserId();
                                      Integer ObjectId =   obj.getObjectSaleId();

                                  if( CustomerId!= null && CustomerId > 0 &&
                                     VendorId!= null && VendorId > 0 &&  
                                     ObjectId!= null && ObjectId > 0 )
                                 {


                                     Vendor v = usrFactory.getVendorById(VendorId);


                                     if(c != null && v != null && obj != null)
                                     {
                                       
                                         Transaction t = PaymentSystem.buy(obj, c,appMode);
                                         if(t.isIsSuccess())
                                         {
                                            
                                             totalAmount += obj.getPrice();
                                             numBought++;
                                             shopper.removeFromCart(obj);


                                         }
                                         else
                                         {
                                             request.setAttribute(TRANSACTION_ROLLEDBACK_MESSAGE, t.getMessage());
                                             //Todo: una macrotransazione che prevede di ripristinare il carrello
                                             // allo stato precedente al checkout totale tipo:
                                             // rollbackTotalCheckout()
                                         }

                                         

                                     }




                                 }

                                    
                                    //------------------------------------------------------------------------
                                    
                                }
                               
                               
                                             request.setAttribute(TRANSACTION_COMMITED_MESSAGE,TOTAL_CHECKOUT_COMMITTED_TEXT);
                                         
                                             request.setAttribute(PREVIOUS_BALANCE,previousBalance);
                                             request.setAttribute(CURRENT_PURCHASE,totalAmount);
                                             request.setAttribute(CURRENT_BALANCE ,c.getAccount().getBalance() );
                               
                                             List<MenuLi> menuItems = mb.getMenuByPage(BUY_PAGE);        
                                          request.setAttribute(MENU_ITEMS, menuItems);

                                          request.getRequestDispatcher(BUY_PAGE).forward(request, response); 
                                 
                             }
                     
                        }
                        else
                        {
                            // Nessun oggetto per il checkout totale: torna alla pagina cliente
                            
                            
                            ObjectSaleFactory factory = ObjectSaleFactoryBuilder.getFactory(appMode);       
                            List<ObjectSale> items = factory.getSellingObjectList(); 
                            
                            request.setAttribute(SELLING_ITEMS, items);
                            
                             List<MenuLi> menuItems = mb.getMenuByPage(CUSTOMER_PAGE);        
                            request.setAttribute(MENU_ITEMS, menuItems);
                            
                            request.getRequestDispatcher(CUSTOMER_PAGE).forward(request, response);
                        
                        }
                       
                   }
                  else
                  {
                      //Riepilogo oggetto e aggiunta carrello
                   
                   
                   //Assumo che username sia impostato
                   String username = (String)session.getAttribute(USERNAME);
                 
                 
                   Customer c = (Customer) session.getAttribute(CUSTOMER) ;

                   //Prelevo dalla richiesta l'id dell'oggetto da acquistare
                   Integer objId = Util.tryParseInt(request.getParameter(OBJECT_ID));


                   if(objId != null && c != null)
                   {                   

                  
                    ObjectSale obj = objFactory.getObjectSaleById(objId.intValue());

                    if(obj != null)
                    {
                        if( obj.getNumOfItems() < 1 )                    
                             request.setAttribute(UNAVAILABLE_OBJECT_MESSAGE, UNAVAILABLE_OBJECT_MESSAGE_TEXT);                   
                        else  
                        {
                        //aggiungiamo alla richiesta l'oggetto                 
                        request.setAttribute(SELECTED_OBJECT,obj);
                        
                        //Aggiungiamo al carrello
                         ShoppingCart shopper = (ShoppingCart)session.getAttribute(SHOPPER);
                         shopper.addToCart(obj);

                        //Otteniamo l'id del venditore
                        Vendor v = obj.getVendor();

                        request.setAttribute(CUSTOMER_ID, c.getUserId());
                        request.setAttribute(VENDOR_ID, v.getUserId());

                        }
                        
                       List<MenuLi> menuItems = mb.getMenuByPage(BUY_PAGE);        
                       request.setAttribute(MENU_ITEMS, menuItems);

                       request.getRequestDispatcher(BUY_PAGE).forward(request, response);                  


                     }

                   }
                       
                    List<MenuLi> menuItems = mb.getMenuByPage(CUSTOMER_PAGE);        
                    request.setAttribute(MENU_ITEMS, menuItems);

                    request.getRequestDispatcher(CUSTOMER_PAGE).forward(request, response);
                 }

               }               



               }
        
           
        }
               List<MenuLi> menuItems = mb.getMenuByPage(LOGIN_PAGE);        
               request.setAttribute(MENU_ITEMS, menuItems);
         
               request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
       
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
