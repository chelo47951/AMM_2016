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

import static Util.Constant.*;
import java.util.Enumeration;
import javax.servlet.http.HttpSession;
import model.factory.sale.ObjectSaleFactory;
import model.factory.sale.ObjectSaleFactoryBuilder;
import model.factory.user.UserFactory;
import model.factory.user.UserFactoryBuilder;

import static Util.Constant.*;
import Util.MenuBuilder;
import Util.MenuLi;
import Util.Util;
import java.util.List;
import model.sale.ObjectSale;
import model.user.Vendor;


/**
 *
 * @author fab
 */
@WebServlet(name = "Venditore", urlPatterns = {"/venditore.html"})
public class Venditore extends HttpServlet {

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
            
            boolean isVendorPresent = false;
        
            while (attributes.hasMoreElements())
            {
              String name = (String) attributes.nextElement();
              
              if(name.equals(IS_VENDOR))
              {
                  isVendorPresent = true;
                  break;
              }
            }
           
            if(isVendorPresent)
           {
               Boolean isVendor = (Boolean)session.getAttribute(IS_VENDOR);
               if(isVendor != null && isVendor == true)
              {  
                  String username = (String)session.getAttribute(USERNAME);
                  Vendor vendor = usrFactory.getVendorByUsername(username);
                
                  ObjectSale objSale = new ObjectSale();
                  objSale.setName("");
                  objSale.setDescription("");
                  objSale.setCategory("");
                  objSale.setImgUrl("");
                  
                  
                   //La servlet gestisce l'aggiunta di un nuovo oggetto o la modifica di uno già inserito
                   if( request.getParameter("Submit") != null )
                   {
                       
                       Integer objectId = Util.tryParseInt(request.getParameter("objectId"));
                       
                       String name = request.getParameter("nomeArticolo");
                       String desc = request.getParameter("descArticolo");
                       String category = request.getParameter("categoria");
                       Integer num = Util.tryParseInt(request.getParameter("numpezzi"));
                       Double price = Util.tryParseDouble(request.getParameter("prezzo"));
                       String imgUrl = request.getParameter("imgurl");
                       
                       
                       if(  name != null &&
                            desc != null &&   //potrebbe essere opzionale
                            category != null &&
                            num != null &&
                            price != null &&
                            imgUrl != null &&
                            vendor != null
                           )
                       {
                           ObjectSale objToAdd = new ObjectSale(name, desc, category, price, num, imgUrl, vendor);
                           
                           if(objectId != null)
                           {
                                objToAdd.setObjectSaleId(objectId);
                                objFactory.updateSellingObjectList(objToAdd);
                           }
                           else
                            objFactory.addToSellingObjectList(objToAdd);
                           
                           request.setAttribute(OBJECT_ADDED_MESSAGE, OBJECT_ADDED_MESSAGE_TEXT);
                           
                           
                            List<ObjectSale> items = objFactory.getSellingObjectListByVendorId(vendor.getUserId()); 

                        request.setAttribute(SELLING_ITEMS, items);
                       
                         List<MenuLi> menuItems = mb.getMenuByPage(VENDOR_PAGE);        
                            request.setAttribute(MENU_ITEMS, menuItems);
                            
                         request.getRequestDispatcher(VENDOR_PAGE).forward(request, response);
                       
                       }
                       
                   }
                    else if( (request.getParameter("Update") != null) && (request.getParameter("objectSaleId") != null) )
                   {
                       // Carica la form con i campi dell'oggetto
                     //  int objectSaleId= request.getParameter("objectSaleId");
                       Integer objectSaleId = Util.tryParseInt( request.getParameter("objectSaleId"));
                       
                        objSale = objFactory.getObjectSaleById(objectSaleId);
                       
                       request.setAttribute(OBJECT_TO_UPDATE,objSale );
                       
                   }
                    
                    
                   else if( (request.getParameter("AddItem") != null) && (request.getParameter("objectSaleId") != null) )
                   {
                       // Carica la form con i campi dell'oggetto
                     //  int objectSaleId= request.getParameter("objectSaleId");
                       Integer objectSaleId = Util.tryParseInt( request.getParameter("objectSaleId"));
                       
                      
                       
                        objSale = objFactory.getObjectSaleById(objectSaleId);
                       
                        objFactory.AddItemOfObjectSale(objSale);
                       
                        List<ObjectSale> items = objFactory.getSellingObjectListByVendorId(vendor.getUserId()); 

                        request.setAttribute(SELLING_ITEMS, items);
                       
                         List<MenuLi> menuItems = mb.getMenuByPage(VENDOR_PAGE);        
                            request.setAttribute(MENU_ITEMS, menuItems);
                            
                         request.getRequestDispatcher(VENDOR_PAGE).forward(request, response);
                       
                   }
                   
                    else if( (request.getParameter("Remove") != null) && (request.getParameter("objectSaleId") != null) )
                    {
                     
                     // Carica la form con i campi dell'oggetto
                     //  int objectSaleId= request.getParameter("objectSaleId");
                       Integer objectSaleId = Util.tryParseInt( request.getParameter("objectSaleId"));
                       objFactory.removeObjectSaleById(objectSaleId);
                       
                      
                        List<ObjectSale> items = objFactory.getSellingObjectListByVendorId(vendor.getUserId()); 

                        request.setAttribute(SELLING_ITEMS, items);
                       
                         List<MenuLi> menuItems = mb.getMenuByPage(VENDOR_PAGE);        
                            request.setAttribute(MENU_ITEMS, menuItems);
                            
                         request.getRequestDispatcher(VENDOR_PAGE).forward(request, response);
                       
                    }

              }
           }
           
      
            List<MenuLi> menuItems = mb.getMenuByPage(VENDOR_PAGE);        
            request.setAttribute(MENU_ITEMS, menuItems);
            request.getRequestDispatcher(UPDATE_OBJECT_PAGE).forward(request, response);
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
