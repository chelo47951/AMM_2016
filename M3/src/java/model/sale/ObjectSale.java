/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.sale;

import model.user.Vendor;
import Util.Constant;
import java.util.Random;

/**
 *
 * @author fab
 */
public class ObjectSale
{
    private int objectSaleId;
    private String name;
    private String description;
    private String category;
    private double price;
    private int numOfItems;
    private String imgUrl;
    
    private Vendor vendor;
    
    
    public ObjectSale()
    {}
    
     public ObjectSale(
              String name,
              String description,
              String category,
              double price,
              int numOfItems,
              String imgUrl,
              Vendor vendor
                        )
    {        
        
             // Generazione id per test
              Random rn = new Random();                       
              this.objectSaleId = Math.abs( rn.nextInt() % Constant.MAX_ID  ); 
              
              this.name = name;
              this.description =  description;
              this.category = category;
              this.price = price;
              this.numOfItems = numOfItems;
              this.imgUrl  = imgUrl;    
              this.vendor = vendor;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the imgUrl
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl the imgUrl to set
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * @return the vendor
     */
    public Vendor getVendor() {
        return vendor;
    }

    /**
     * @param vendor the vendor to set
     */
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    /**
     * @return the numOfItems
     */
    public int getNumOfItems() {
        return numOfItems;
    }

    /**
     * @param numOfItems the numOfItems to set
     */
    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the objectSaleId
     */
    public int getObjectSaleId() {
        return objectSaleId;
    }

    /**
     * @param objectSaleId the objectSaleId to set
     */
    public void setObjectSaleId(int objectSaleId) {
        this.objectSaleId = objectSaleId;
    }
    
}
