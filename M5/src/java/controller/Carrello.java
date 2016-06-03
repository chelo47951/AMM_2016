/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static Util.Constant.*;

import Util.MenuBuilder;
import Util.MenuLi;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.factory.sale.ObjectSaleFactory;
import model.factory.sale.ObjectSaleFactoryBuilder;
import model.factory.user.UserFactory;
import model.factory.user.UserFactoryBuilder;
import model.sale.ObjectSale;
import model.sale.ShoppingCart;
import model.user.Customer;

/**
 *
 * @author fab
 */
@WebServlet(name = "Carrello", urlPatterns = {"/carrello.html"})
public class Carrello extends HttpServlet {

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
                   
                   if(request.getParameter("Svuota") != null)
                   {
                      ShoppingCart shopper = (ShoppingCart) session.getAttribute(SHOPPER);
                      shopper.clearCart();
                      
                      
                            ObjectSaleFactory factory = ObjectSaleFactoryBuilder.getFactory(appMode);       
                            List<ObjectSale> items = factory.getSellingObjectList(); 
                            
                            request.setAttribute(SELLING_ITEMS, items);
                        
                            
                            
                            List<MenuLi> menuItems = mb.getMenuByPage(CUSTOMER_PAGE);        
                            request.setAttribute(MENU_ITEMS, menuItems);
                            
                            request.getRequestDispatcher(CUSTOMER_PAGE).forward(request, response);
                      
                   }
                   
                   
                     Customer c = (Customer) session.getAttribute(CUSTOMER);
                      List<ObjectSale> items =  new ArrayList<ObjectSale>( c.getCart().getItems());
                      
                     request.setAttribute("cartItems", items);
                      
                     List<MenuLi> menuItems = mb.getMenuByPage(CART_PAGE);        
                    request.setAttribute(MENU_ITEMS, menuItems);

                    request.getRequestDispatcher(CART_PAGE).forward(request, response);
                      
               }
            }
            
               List<MenuLi> menuItems = mb.getMenuByPage(LOGIN_PAGE);        
               request.setAttribute(MENU_ITEMS, menuItems);
         
               request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
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
