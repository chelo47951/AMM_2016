/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory.sale;

import java.util.List;
import model.sale.ObjectSale;

/**
 *
 * @author fab
 */
public abstract class ObjectSaleFactory
{
    protected  List<ObjectSale> items;
    
   protected String connectionString;
   
   public void setConnectionString(String s)
   {
	this.connectionString = s;
   }
    public String getConnectionString()
    {
            return this.connectionString;
    } 
    
    public abstract ObjectSale getObjectSaleById(int id);
    public abstract List<ObjectSale> getSellingObjectList();
    public abstract List<ObjectSale> getSellingObjectListByCategory(String category);
    public abstract List<ObjectSale> getSellingObjectListByVendorId(String category);
    public abstract ObjectSale addToSellingObjectList(ObjectSale objSale);
    
}
