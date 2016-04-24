/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import static Util.Constant.*;


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
         
        ObjectSale kirk = new ObjectSale(
                "Captain Kirk",
                "Star Trek: Captain Kirk",
                ACTION_FIGURE,
                299.00,
                2,
                "img/kirk.jpg"                                
        );
        
        items.add(kirk);
        
        
          ObjectSale crow = new ObjectSale(
                "Eric Draven",
                "The Crow: Eric Draven",
                ACTION_FIGURE,
                235.00,
                4,
                "img/theCrow.jpg"                                
        );
        
        items.add(crow);
        
          ObjectSale devilman = new ObjectSale(
                "Devilman",
                "Devilman anime version",
                ACTION_FIGURE,
                85.00,
                2,
                "img/devilman.jpg"                                
        );
        
        items.add(devilman);
        
        
        
        
           ObjectSale jeeg = new ObjectSale(
                "Jeeg",
                "Jeeg",
                ROBOT,
                155.00,
                5,
                "img/jeeg.jpg"                                
        );
        
        items.add(jeeg);
        
        
        
           ObjectSale goldrake = new ObjectSale(
                "Goldrake",
                "Goldrake",
                ROBOT,
                145.00,
                3,
                "img/goldrake.jpg"                                
        );
        
        items.add(goldrake);
        
        
        
            ObjectSale nausicaa = new ObjectSale(
                "Nausicaa",
                "Nausicaa della valle del vento",
                DVD,
                35.00,
                6,
                "img/Nausicaa-dvd.png"                                
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public List<ObjectSale> getSellingObjectListByVendorId(String category) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
