/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author fab
 */
public class DbObjectSaleFactory extends ObjectSaleFactory 
{
   private static DbObjectSaleFactory instance;
    
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
    public ObjectSale getObjectSaleById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ObjectSale> getSellingObjectList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ObjectSale> getSellingObjectListByCategory(String category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ObjectSale> getSellingObjectListByVendorId(String category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
