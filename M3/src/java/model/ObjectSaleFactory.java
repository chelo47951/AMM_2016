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
public abstract class ObjectSaleFactory
{
    protected  List<ObjectSale> items;
    public abstract ObjectSale getObjectSaleById(int id);
    public abstract List<ObjectSale> getSellingObjectList();
    public abstract List<ObjectSale> getSellingObjectListByCategory(String category);
    public abstract List<ObjectSale> getSellingObjectListByVendorId(String category);
    
}
