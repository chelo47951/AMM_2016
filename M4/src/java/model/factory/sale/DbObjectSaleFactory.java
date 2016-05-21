/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory.sale;

import Util.Constant;
import static Util.Constant.DB_FACTORY_MODE;
import static Util.Constant.DB_PASSWORD;
import static Util.Constant.DB_USERNAME;
import static Util.Constant.IS_CUSTOMER;
import static Util.Constant.IS_VENDOR;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.factory.user.DbUserFactory;
import model.factory.user.UserFactory;
import model.factory.user.UserFactoryBuilder;
import model.payment.Account;
import model.sale.ObjectSale;
import model.user.Customer;
import model.user.User;
import model.user.Vendor;

/**
 *
 * @author fab
 */
public class DbObjectSaleFactory extends ObjectSaleFactory 
{
   private static DbObjectSaleFactory instance;
    private Connection conn;
     
   
     public void connect() 
     {
         try 
         {
             conn = DriverManager.getConnection(connectionString, DB_USERNAME, DB_PASSWORD);
         } 
         catch (SQLException ex)
         {
             Logger.getLogger(DbUserFactory.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
     
      public void disconnect()
     {
         try 
         {
             conn.close();
         } 
         catch (SQLException ex) 
         {
             Logger.getLogger(DbUserFactory.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
   

    
    private DbObjectSaleFactory()
    {
        //TODO:
        //connessione al db
    }
    
    public static DbObjectSaleFactory getInstance()
    {
       if(instance == null)
       {
           instance = new DbObjectSaleFactory();
       }
       
        return instance;
    }
    
    

    @Override
    public ObjectSale getObjectSaleById(int id) 
    {
        ObjectSale o = null;
        
         connect();
         try 
         {
             String sql = "select * from OBJECT_SALES "
                     + "where OBJECT_SALE_ID = ?";
             
             PreparedStatement stmt = conn.prepareStatement(sql);
             
             stmt.setInt(1, id);
             
             ResultSet set = stmt.executeQuery();
             
             while (set.next()) 
             {
                 UserFactory userfactory =  UserFactoryBuilder.getFactory(DB_FACTORY_MODE);
                 Vendor vendor = userfactory.getVendorById(set.getInt("VENDOR_ID"));
                 
                 o = new ObjectSale(
                           set.getInt("OBJECT_SALE_ID"),
                           set.getString("OBJECT_NAME"),
                           set.getString("DESCRIPTION"), 
                           set.getString("CATEGORY"),
                           set.getDouble("PRICE"),                           
                           set.getInt("NUM_OF_ITEMS"),
                           set.getString("IMG_URL"), 
                           vendor
                   ); 
                                   
                 
                
             }
             
              stmt.close();
              disconnect();
              return o;
             
         }
         catch (SQLException ex)
         {
             Logger.getLogger(DbUserFactory.class.getName()).log(Level.SEVERE, null, ex);
            
             disconnect();
             return null;
            
         }
    }

    @Override
    public List<ObjectSale> getSellingObjectList()
    {
       
         connect();
         items = new ArrayList<>();
         
         try 
         {
             String sql = "select * from OBJECT_SALES ";
                    
             
             Statement stmt = conn.createStatement();
             ResultSet set = stmt.executeQuery(sql);
             
             while (set.next()) 
             {
                  UserFactory userfactory =  UserFactoryBuilder.getFactory(DB_FACTORY_MODE);
                  Vendor vendor = userfactory.getVendorById(set.getInt("VENDOR_ID"));
                 
                   ObjectSale o = new ObjectSale(
                           set.getInt("OBJECT_SALE_ID"),
                           set.getString("OBJECT_NAME"),
                           set.getString("DESCRIPTION"), 
                           set.getString("CATEGORY"),
                           set.getDouble("PRICE"),                           
                           set.getInt("NUM_OF_ITEMS"),
                           set.getString("IMG_URL"), 
                           vendor
                   ); 
                   
                   items.add(o);
                     
             }
             
             stmt.close();
             disconnect();
             return items;    
                
         }
         catch (SQLException ex)
         {
             Logger.getLogger(DbUserFactory.class.getName()).log(Level.SEVERE, null, ex);
             disconnect();
             return null;
            
         }
         
      
    }

    @Override
    public List<ObjectSale> getSellingObjectListByCategory(String category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ObjectSale> getSellingObjectListByVendorId(String category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSale addToSellingObjectList(ObjectSale objSale) 
    {
       
        
        
        try
        {
          connect();
            
           String sql = "INSERT INTO OBJECT_SALES (OBJECT_SALE_ID, OBJECT_NAME, DESCRIPTION, CATEGORY, PRICE,NUM_OF_ITEMS,IMG_URL,VENDOR_ID) " +
" VALUES (default,?,?,?,?,?,?,?)";
             
             PreparedStatement stmt = conn.prepareStatement(sql);
             
             stmt.setString(1, objSale.getName());
             stmt.setString(2, objSale.getDescription());
             stmt.setString(3, objSale.getCategory());
             stmt.setDouble(4, objSale.getPrice());
             stmt.setInt(5, objSale.getNumOfItems());
             stmt.setString(6, objSale.getImgUrl());
             stmt.setInt(7, objSale.getVendor().getUserId());
             
             
             int numOrRows = stmt.executeUpdate();
            
          disconnect();        
          return objSale;
        }
        catch(SQLException ex)
        {
             Logger.getLogger(DbUserFactory.class.getName()).log(Level.SEVERE, null, ex);
             disconnect();
             return null;
        }     
       
    }
    
}
