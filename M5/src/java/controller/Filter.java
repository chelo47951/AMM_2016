/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static Util.Constant.APP_MODE;
import static Util.Constant.CUSTOMER_PAGE;
import static Util.Constant.FILTER_QUERY;
import static Util.Constant.IS_CUSTOMER;
import static Util.Constant.LIST_JSON_PAGE;
import static Util.Constant.LOGIN_PAGE;
import static Util.Constant.MENU_ITEMS;
import static Util.Constant.SELLING_ITEMS;
import Util.MenuBuilder;
import Util.MenuLi;
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
import model.factory.sale.ObjectSaleFactory;
import model.factory.sale.ObjectSaleFactoryBuilder;
import model.sale.ObjectSale;

/**
 *
 * @author fab
 */
@WebServlet(name = "Filter", urlPatterns = {"/filter.json"})
public class Filter extends HttpServlet {

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
               
             String filterQuery = request.getParameter(FILTER_QUERY);
             if(filterQuery != null) 
             {
             //Effetuiamo la ricerca filtrata  
             ObjectSaleFactory factory =  ObjectSaleFactoryBuilder.getFactory(appMode);        
             List<ObjectSale> items = factory.getSellingObjectList(filterQuery); 
             
             request.setAttribute(SELLING_ITEMS, items);
             
             response.setContentType("application/json");
             response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
             response.setHeader("Cache-Control", "no-store, no-cache, "
                        + "must-revalidate");
             
             
              // Genero il json con una jsp
                request.getRequestDispatcher(LIST_JSON_PAGE).
                        forward(request, response);

        
             }
           
            
           }
        }
        
 
       }
       
       
         // Se non esiste neanche la sessione rimandiamo al login
         
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
