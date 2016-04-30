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
import model.ObjectSale;
import model.ObjectSaleFactory;
import model.TestObjectSaleFactory;


// Le costanti utilizzate nel codice
import static Util.Constant.*;
import Util.Util;
import model.Customer;
import model.TestUserFactory;
import model.UserFactory;




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
        
        
          HttpSession session = request.getSession(false);
       
         if(session != null)
        {
           
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
               //Assumo che username sia impostato
               String username = (String)session.getAttribute(USERNAME);
               UserFactory usrFactory = TestUserFactory.getInstance();
               
               //Nell'applicazione assumo che il campo username abbia vincolo UNIQUE
               // inoltre assumo dal momento che isCustomer è true, che l'utente nella sessione sia un customer
               Customer c = usrFactory.getCustomerByUsername(username) ;
               
               //Prelevo dalla richiesta l'id dell'oggetto da acquistare
               Integer objId = Util.tryParse(request.getParameter(OBJECT_ID));
              
               
               if(objId != null && c != null)
               {                   
               
                ObjectSaleFactory objFactory = TestObjectSaleFactory.getInstance();
                ObjectSale obj = objFactory.getObjectSaleById(objId.intValue());
                
                if(obj != null)
                {
                    if( obj.getNumOfItems() < 1 )                    
                         request.setAttribute(UNAVAILABLE_OBJECT_MESSAGE, UNAVAILABLE_OBJECT_MESSAGE_TEXT);                   
                    else                      
                    //aggiungiamo alla richiesta l'oggetto                 
                    request.setAttribute(SELECTED_OBJECT,obj);
                     
                    request.getRequestDispatcher(BUY_PAGE).forward(request, response);                  
                
                    
                 }
                
               }
               
                 request.getRequestDispatcher(CUSTOMER_PAGE).forward(request, response);
               
           }               
             
           
            
           }
        
           
        }
         
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
