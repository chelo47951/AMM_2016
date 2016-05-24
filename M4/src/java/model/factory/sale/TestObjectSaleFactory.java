/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory.sale;

import java.util.ArrayList;
import java.util.List;
import model.sale.ObjectSale;
import static Util.Constant.*;
import model.factory.user.TestUserFactory;
import model.user.Vendor;


/**
 *
 * @author fab
 */
public class TestObjectSaleFactory extends ObjectSaleFactory
{
    private static TestObjectSaleFactory instance;
    
    private TestObjectSaleFactory()
    {
    
        
       items = new ArrayList<>();
       
       
         // Test: hardcoded items
         
        Vendor vendor = TestUserFactory.getInstance().getVendorByUsername("verdig55");
         
        ObjectSale kirk = new ObjectSale(
                "Captain Kirk",
                "Star Trek: Captain Kirk",
                ACTION_FIGURE,
                299.00,
                3,
                "img/kirk.jpg",
                vendor
        );
        
        items.add(kirk);
        
        
          ObjectSale crow = new ObjectSale(
                "Eric Draven",
                "The Crow: Eric Draven",
                ACTION_FIGURE,
                235.00,
                0,
                "img/theCrow.jpg",
                vendor                                
        );
        
        items.add(crow);
        
          ObjectSale devilman = new ObjectSale(
                "Devilman",
                "Devilman anime version",
                ACTION_FIGURE,
                85.00,
                2,
                "img/devilman.jpg",
                vendor                                
        );
        
        items.add(devilman);
        
        
        
        
           ObjectSale jeeg = new ObjectSale(
                "Jeeg",
                "Jeeg",
                ROBOT,
                155.00,
                5,
                "img/jeeg.jpg" ,
                vendor                               
        );
        
        items.add(jeeg);
        
        
        
           ObjectSale goldrake = new ObjectSale(
                "Goldrake",
                "Goldrake",
                ROBOT,
                145.00,
                3,
                "img/goldrake.jpg",
                vendor                                
        );
        
        items.add(goldrake);
        
        
        
            ObjectSale nausicaa = new ObjectSale(
                "Nausicaa",
                "Nausicaa della valle del vento",
                DVD,
                35.00,
                6,
                "img/Nausicaa-dvd.png",
                vendor                               
        );
        
        items.add(nausicaa);
        
        
    }
    
    public static TestObjectSaleFactory getInstance()
    {
       if(instance == null)
       {
           instance = new TestObjectSaleFactory();
       }
       
        return instance;
    }
    
    
    

    @Override
    public ObjectSale getObjectSaleById(int id) 
    {
       
         if( id < 1)
            return null;
               
        for(ObjectSale o: items)
        {
            if(o.getObjectSaleId()== id)
            {
                //trovato
                return o;
            }
        }
        
        return null;
    }

    @Override
    public List<ObjectSale> getSellingObjectList()
    {        
        
        return items;
    }

    @Override
    public List<ObjectSale> getSellingObjectListByCategory(String category)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ObjectSale> getSellingObjectListByVendorId(int vendorId) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectSale addToSellingObjectList(ObjectSale objSale) 
    {
        items.add(objSale);
        
        return objSale;
    }

    @Override
    public boolean updateSellingObjectList(ObjectSale objSale) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeObjectSaleById(Integer objectSaleId) {
       return true;
    }

    @Override
    public boolean AddItemOfObjectSale(ObjectSale objSale) {
        return true;
    }
    
    
}
