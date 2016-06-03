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
import model.factory.user.TestUserFactory;
import model.user.User;
import model.factory.user.UserFactory;


import java.util.List;
import javax.servlet.http.HttpSession;
import model.user.Customer;
import model.sale.ObjectSale;
import model.factory.sale.ObjectSaleFactory;
import model.sale.ShoppingCart;
import model.factory.sale.TestObjectSaleFactory;
import model.user.Vendor;

// Le costanti utilizzate nel codice
import static Util.Constant.*;
import Util.MenuBuilder;
import Util.MenuLi;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.factory.sale.ObjectSaleFactoryBuilder;
import model.factory.user.UserFactoryBuilder;



/**
 *
 * @author fab
 */
@WebServlet(name = "Login", urlPatterns = {"/login.html"},loadOnStartup = 0)
public class Login extends HttpServlet {
    
    
    @Override 
    public void init()
    {
       
        
      // String dbConnectionString =  JDBC_DERBY + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
      String dbConnectionString =  JDBC_DERBY + DB_URL;
        try
        {
            Class.forName(JDBC_DRIVER);
        } 
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Utilizziamo un parametro per discriminare la modalità test hard-coded da quella con il db
        String appMode = getServletContext().getInitParameter(APP_MODE);
       
        if(appMode.equals(DB_FACTORY_MODE)) 
        {
         ObjectSaleFactory objFactory =  ObjectSaleFactoryBuilder.getFactory(DB_FACTORY_MODE);
         objFactory.setConnectionString(dbConnectionString);
         
         UserFactory usrfactory =  UserFactoryBuilder.getFactory(DB_FACTORY_MODE);
         usrfactory.setConnectionString(dbConnectionString);
        }
         
    } 
    
    
   
    

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
             
        HttpSession session = request.getSession(true);
        
        
        String appMode = session.getServletContext().getInitParameter(APP_MODE);
        
        UserFactory userfactory =  UserFactoryBuilder.getFactory(appMode);
        
        if( request.getParameter("Submit") != null )
        {
            
                String username = request.getParameter(USERNAME);
                String pwd =      request.getParameter(PASSWORD);

                if( username!= null && pwd != null )
                {            
                    User user = userfactory.getUserByUsername(username);

                    if(userfactory.verifyPassword(user, pwd))
                    {
                        //Login avvenuto con successo
                        session.setAttribute(IS_LOGGED_IN, true);
                        session.setAttribute(USERNAME, user.getUsername());                      
                       
                                                
                        if( user instanceof Customer )
                        {                            
                            session.setAttribute(IS_CUSTOMER, true);
                            session.setAttribute(CUSTOMER, user);
                            session.removeAttribute(IS_VENDOR);
                            session.removeAttribute(VENDOR);
                            
                            ObjectSaleFactory factory = ObjectSaleFactoryBuilder.getFactory(appMode);       
                            List<ObjectSale> items = factory.getSellingObjectList(); 
                            
                            request.setAttribute(SELLING_ITEMS, items);
                            ShoppingCart shopper = new ShoppingCart();
                            shopper.clearCart();
                            ((Customer)user).setCart(shopper);
                            session.setAttribute(SHOPPER, shopper);
                            
                            
                            List<MenuLi> menuItems = mb.getMenuByPage(CUSTOMER_PAGE);        
                            request.setAttribute(MENU_ITEMS, menuItems);
                            
                            request.getRequestDispatcher(CUSTOMER_PAGE).forward(request, response);
                        }
                        else if ( user instanceof Vendor )
                        {
                            session.setAttribute(IS_VENDOR, true);
                            session.setAttribute(VENDOR, user);
                            session.removeAttribute(IS_CUSTOMER);
                            session.removeAttribute(CUSTOMER);
                            session.removeAttribute(SHOPPER);
                            
                            
                             ObjectSaleFactory factory = ObjectSaleFactoryBuilder.getFactory(appMode);    
                             List<ObjectSale> items = factory.getSellingObjectListByVendorId(user.getUserId()); 

                             request.setAttribute(SELLING_ITEMS, items);
                            
                            List<MenuLi> menuItems = mb.getMenuByPage(VENDOR_PAGE);        
                            request.setAttribute(MENU_ITEMS, menuItems);
                            
                            request.getRequestDispatcher(VENDOR_PAGE).forward(request, response);
                        }
                    }

                }                
                
                request.setAttribute(LOGIN_ERROR_MESSAGE, LOGIN_ERROR_MESSAGE_TEXT);
                
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
