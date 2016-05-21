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
    
    // Modalita app: test o db
    public final static String APP_MODE = "APP_MODE";
    public final static String TEST_FACTORY_MODE = "TestFactory";
    public final static String DB_FACTORY_MODE = "DbFactory";
    
    //Apache derby
    public final static  String JDBC_DERBY = "jdbc:derby:";
    public final static  String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    public final static  String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    public final static  String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    // Accesso al db
    public static final String DB_USERNAME = "robo";
    public static final String DB_PASSWORD = "robo";
    
    
    
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
      public final static String CART_PAGE = BASE_PATH   +   "carrello.jsp";
      public final static String BUY_COMMIT = BASE_PATH   +   "conferma_acquisto.jsp";
      
      
      // Per generazione dei menu
      public final static String MENU_ITEMS = "menuItems";
      
      
    
      
      //Session attributes
      public final static String IS_LOGGED_IN = "IsLoggedIn";
      public final static String IS_CUSTOMER = "CUSTOMER";
      public final static String IS_VENDOR = "VENDOR";
      public final static String CUSTOMER = "Customer";
      public final static String VENDOR = "Vendor";
     
      
      
      //Request attributes
      public final static String USERNAME = "Username" ; 
      public final static String PASSWORD = "Password" ;
      
      public final static String SELECTED_OBJECT = "o";
      
      public final static String CUSTOMER_ID = "CustomerId";
      public final static String VENDOR_ID = "VendorId";
      public final static String OBJECT_ID = "ObjectSaleId";
      
      public final static String OBJECT_NAME = "ObjectName";
      public final static String OBJECT_DESCRIPTION = "ObjectDescription";
      public final static String OBJECT_CATEGORY = "ObjectCategory";
      public final static String NUM_OF_ITEMS = "NumOfItems";
      public final static String OBJECT_IMG_URL = "ObjectImgUrl";
      public final static String OBJECT_PRICE = "ObjectPrice";
      public final static String CURRENT_PURCHASE = "CurrentPurchase";
      public final static String PREVIOUS_BALANCE = "PreviousBalance";
      public final static String CURRENT_BALANCE = "CurrentBalance";
      
     
      
            
      public final static String SELLING_ITEMS = "sellingItems"; 
      public final static String LOGIN_ERROR_MESSAGE = "LoginErrorMessage";
      public final static String UNAVAILABLE_OBJECT_MESSAGE = "UnavailableObjectMessage";
      
      public final static String TRANSACTION_COMMITED_MESSAGE = "TransactionCommittedMessage";
      public final static String TRANSACTION_ROLLEDBACK_MESSAGE = "TransactionRolledBackMessage";
      public final static String OBJECT_ADDED_MESSAGE = "ObjectAdded";
   
    
      // Messages
       public final static String LOGIN_ERROR_MESSAGE_TEXT = "Non è stato possibile autenticare l'utente. Verificare username e password";
       public final static String UNAVAILABLE_OBJECT_MESSAGE_TEXT = "Siamo spiacenti, ma l'oggetto scelto non è più disponibile";
       public final static String OBJECT_ADDED_MESSAGE_TEXT = "L'oggetto è stato aggiunto correttamente a quelli in vendita.";
     
       
       public final static String TRANSACTION_COMMITED_MESSAGE_TEXT = "La transazione si è conclusa con successo.";
       public final static String TRANSACTION_ROLLEDBACK_MESSAGE_TEXT = "La transazione è stata annullata per il seguente motivo: ";
       public final static String TRANSACTION_ROLLEDBACK_REASON_CUSTOMER_TEXT = "Disponibilità insufficiente per completare l'acuisto";
       public final static String TRANSACTION_ROLLEDBACK_REASON_VENDOR_TEXT = "Impossibile completare l'accredito sul conto del venditore";
}
