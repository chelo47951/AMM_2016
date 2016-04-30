package Util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fab
 */
public class Constant
{
    public final static int MAX_ID = 1024;
    
    public final static String TEST_FACTORY_MODE = "TestFactory";
    public final static String DB_FACTORY_MODE = "DbFactory";
    
    
    // Categorie: eventualmente da evolvere in un enum
    public final static String ACTION_FIGURE = "Action Figure";
    public final static String ANIME = "Anime";
    public final static String ROBOT = "Robot";
    public final static String DVD = "DVD";
    
      // JSP path
      public final static String BASE_PATH = "jsp/";
      
      public final static String LOGIN_PAGE = BASE_PATH  +   "login.jsp";
      public final static String DESCRIPTION_PAGE= BASE_PATH   +   "descrizione.jsp";
      public final static String CUSTOMER_PAGE = BASE_PATH   +   "cliente.jsp";
      public final static String VENDOR_PAGE = BASE_PATH   +   "venditore.jsp";
      public final static String BUY_PAGE = BASE_PATH   +   "acquista.jsp";
      public final static String BUY_COMMIT = BASE_PATH   +   "conferma_acquisto.jsp";
    
      
      //Session attributes
      public final static String IS_LOGGED_IN = "IsLoggedIn";
      public final static String IS_CUSTOMER = "IsCustomer";
      public final static String IS_VENDOR = "IsVendor";
      public final static String CUSTOMER = "Customer";
      public final static String VENDOR = "Vendor";
     
      
      
      //Request attributes
      public final static String USERNAME = "Username" ; 
      public final static String PASSWORD = "Password" ;
      
      public final static String SELECTED_OBJECT = "o";
      public final static String OBJECT_ID = "ObjectSaleId";
      public final static String OBJECT_NAME = "ObjectName";
      public final static String OBJECT_DESCRIPTION = "ObjectDescription";
      public final static String OBJECT_CATEGORY = "ObjectCategory";
      public final static String NUM_OF_ITEMS = "NumOfItems";
      public final static String OBJECT_IMG_URL = "ObjectImgUrl";
      public final static String OBJECT_PRICE = "ObjectPrice";
     
      
            
      public final static String SELLING_ITEMS = "sellingItems"; 
      public final static String LOGIN_ERROR_MESSAGE = "LoginErrorMessage";
      public final static String UNAVAILABLE_OBJECT_MESSAGE = "UnavailableObjectMessage";
      
   
    
      // Messages
       public final static String LOGIN_ERROR_MESSAGE_TEXT = "Non è stato possibile autenticare l'utente. Verificare username e password";
       public final static String UNAVAILABLE_OBJECT_MESSAGE_TEXT = "Siamo spiacenti, ma l'oggetto scelto non è più disponibile";
    
}
