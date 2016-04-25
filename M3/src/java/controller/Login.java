/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TestUserFactory;
import model.User;
import model.UserFactory;

import static Util.Constant.*;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.ObjectSale;
import model.ObjectSaleFactory;
import model.ShoppingCart;
import model.TestObjectSaleFactory;
import model.Vendor;

/**
 *
 * @author fab
 */
@WebServlet(name = "Login", urlPatterns = {"/login.html"})
public class Login extends HttpServlet {

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
      
        HttpSession session = request.getSession(true);
        
        UserFactory userfactory = TestUserFactory.getInstance();
        
        if( request.getParameter("Submit") != null )
        {
            
                String username = request.getParameter("username");
                String pwd =      request.getParameter("pwd");

                if( username!= null && pwd != null )
                {            
                    User user = userfactory.getUserByUsername(username);

                    if(userfactory.verifyPassword(username, pwd))
                    {
                        //Login avvenuto con successo
                        session.setAttribute("LoggedIn", true);
                        session.setAttribute("Username", user.getUsername());
                        
                        
                        if( user instanceof Customer )
                        {
                            request.setAttribute("Customer", user);
                            session.setAttribute("IsCustomer", true);
                            session.removeAttribute("IsVendor");
                            
                            ObjectSaleFactory factory = TestObjectSaleFactory.getInstance();        
                            List<ObjectSale> items = factory.getSellingObjectList(); 
                            
                            request.setAttribute("sellingItems", items);
                            request.setAttribute("shopperImgUrl", ShoppingCart.SHOP_CART_ICON);
                            
                            
                            request.getRequestDispatcher(CUSTOMER_PAGE).forward(request, response);
                        }
                        else if ( user instanceof Vendor )
                        {
                            session.setAttribute("IsVendor", true);
                            session.removeAttribute("IsCustomer");
                            request.setAttribute("Vendor", user);
                            request.getRequestDispatcher(VENDOR_PAGE).forward(request, response);
                        }
                    }

                }
                
                String errorMessage = "Non è stato possibile autenticare l'utente. Verificare username e password";
                request.setAttribute("errorMessage", errorMessage);
                
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
